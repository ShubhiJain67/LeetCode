class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        email_account_id_map, name_account_id_map = self.get_merged_emails_and_related_names(accounts)
        # print(email_account_id_map)
        # print(name_account_id_map)
        merged_accounts = self.get_merged_accounts_information(email_account_id_map, name_account_id_map)
        return merged_accounts
    
    def get_merged_emails_and_related_names(self, accounts):
        email_account_id_map = {}
        name_account_id_map = {}
        account_count = 0
        for account in accounts:
            new_email_ids = set(account[1:])
            account_ids = self.get_all_existing_account_ids(email_account_id_map, new_email_ids)
            if account_ids:
                self.merge_accounts_with_new_emails(new_email_ids, email_account_id_map, name_account_id_map, account_ids)
            else:
                account_count +=1
                name_account_id_map[account_count] = account[0]
                email_account_id_map[account_count] = new_email_ids
        
        return email_account_id_map, name_account_id_map
    
    def get_all_existing_account_ids(self, email_account_id_map, new_email_ids):
        account_ids = []
        for account_id in email_account_id_map.keys():
            if email_account_id_map[account_id].intersection(new_email_ids):
                account_ids.append(account_id)
        return account_ids

    def merge_accounts_with_new_emails(self, new_email_ids, email_account_id_map, name_account_id_map, account_ids):
        new_account_id = min(account_ids)
        name = name_account_id_map[new_account_id]
        all_email_ids = new_email_ids
        for account_id in account_ids:
            all_email_ids = all_email_ids.union(email_account_id_map[account_id])
            del email_account_id_map[account_id]
            del name_account_id_map[account_id]
        email_account_id_map[new_account_id] = all_email_ids
        name_account_id_map[new_account_id] = name
    
    def get_merged_accounts_information(self, email_account_id_map, name_account_id_map):
        accounts = {}
        for account_id in name_account_id_map:
            info = [name_account_id_map[account_id]]
            info.extend(sorted(email_account_id_map[account_id]))
            accounts[account_id] = info
        return accounts.values()
