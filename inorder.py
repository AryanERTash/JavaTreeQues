
#https://www.geeksforgeeks.org/problems/inorder-traversal-iterative/1

class Node:
    def init(self, val):
        self.data = val
        self.left = None
        self.right = None


# Return a list containing the inorder traversal of the given tree
class Solution:
    def inOrder(self, root):
        result = []
        if root is None:
            return result

        def helper(curr):
            if curr is None:
                return None

            left = helper(curr.left)
            if left is not None:
                yield from left
            
            yield curr.data


            right = helper(curr.right)

            if right is not None:
                yield from right
            

            return None
        

        gen = helper(root)

        for item in gen:
            result.append(item)
        

        return result
