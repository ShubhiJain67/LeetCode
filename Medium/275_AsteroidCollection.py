class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        asteroid_stack = []
        asteroid_index = 0
        while asteroid_index < len(asteroids):
            curr_asteroid = asteroids[asteroid_index]
            last_asteroid = asteroid_stack[len(asteroid_stack) - 1] if asteroid_stack else None
            if not last_asteroid:
                # <- or ->
                # print("<- or -> with {}".format(curr_asteroid))
                asteroid_stack.append(curr_asteroid)
            elif curr_asteroid > 0:
                # <- -> or -> ->
                # print("<- -> or -> -> with {} and {}".format(last_asteroid, curr_asteroid))
                asteroid_stack.append(curr_asteroid)
            elif curr_asteroid < 0 and last_asteroid < 0:
                # <- <-
                # print("<- <- with {} and {}".format(last_asteroid, curr_asteroid))
                asteroid_stack.append(curr_asteroid)
            else:
                # -> <-
                # print("-> <- with {} and {}".format(last_asteroid, curr_asteroid))
                self.handle_collission(asteroid_stack, curr_asteroid)
            asteroid_index+=1
        return asteroid_stack
    
    def handle_collission(self, asteroid_stack, curr_asteroid):
        # print("handling collision with {} and {}".format(asteroid_stack, curr_asteroid))
        destroy_asteroid = True
        while destroy_asteroid and asteroid_stack:
            last_asteroid = asteroid_stack[len(asteroid_stack) - 1]
            if last_asteroid < 0:
                break
            elif last_asteroid > (curr_asteroid * -1):
                destroy_asteroid = False
                curr_asteroid = 0
            elif last_asteroid == (curr_asteroid * -1):
                asteroid_stack.pop()
                destroy_asteroid = False
                curr_asteroid = 0
            else:
                asteroid_stack.pop()
        if destroy_asteroid:
            asteroid_stack.append(curr_asteroid)
        # print("asteroid_stack now : {}".format(asteroid_stack))

