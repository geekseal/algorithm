import sys
from collections import deque
sys.stdin = open("input.txt", "r")

NOT_YET = 0
AS_ROOT = 1
AS_INTERNAL = 2

class Tree:
    class Node:
        def __init__(self, key):
            self.key = key
            self.left = None
            self.right = None
            self.parent = None

    def __init__(self, vertex_num):
        self.nodes = [None] * (vertex_num + 1)
        self.check_list = [NOT_YET] * (vertex_num + 1)

    def find_node(self, key):
        return self.nodes[key]

    def is_root(self, key):
        return True if self.check_list[key] == AS_ROOT else False

    def is_internal(self, key):
        return True if self.check_list[key] == AS_INTERNAL else False

    def add_new_pair(self, p, c):
        self.nodes[p] = self.Node(p)
        self.nodes[c] = self.Node(c)
        self.check_list[p] = AS_ROOT
        self.check_list[c] = AS_INTERNAL

        self.nodes[p].left = self.nodes[c]
        self.nodes[c].parent = self.nodes[p]

    def add_parent(self, p, c):
        self.nodes[p] = self.Node(p)
        self.check_list[p] = AS_ROOT
        self.check_list[c] = AS_INTERNAL

        self.nodes[p].left = self.nodes[c]
        self.nodes[c].parent = self.nodes[p]

    def add_child(self, p, c):
        self.nodes[c] = self.Node(c)
        self.check_list[c] = AS_INTERNAL

        if self.find_node(p).left == None:
            self.find_node(p).left = self.nodes[c]
        else:
            self.find_node(p).right = self.nodes[c]
        self.nodes[c].parent = self.nodes[p]

    def join(self, p, c):
        self.find_node(c).parent = self.find_node(p)
        self.check_list[c] = AS_INTERNAL

        if self.find_node(p).left == None:
            self.find_node(p).left = self.find_node(c)
        else:
            self.find_node(p).right = self.find_node(c)

    def parent(self, p):
        pos = self.find_node(p)
        parents = [pos.key]
        # yield pos.key
        while pos.parent != None:
            parents.append(pos.parent.key)
            # yield pos.parent.key
            pos = pos.parent
        return parents

    def children(self, p):
        pos = self.find_node(p)
        queue = deque([pos])
        children = []
        while len(queue) != 0:
            q = queue.popleft()
            children.append(q)
            if q.left != None:
                queue.append(q.left)
            if q.right != None:
                queue.append(q.right)
        return children

T = int(input())
for case_num in range(T):
    V, E, target1, target2 = map(int, input().split())
    inp = list(map(int, input().split()))
    edges = [[x, y] for x, y in zip(inp[0::2], inp[1::2])]
    tree = Tree(V)

    for edge in edges:
        parent_key, child_key = edge

        if tree.find_node(parent_key) == None:
            if tree.find_node(child_key) == None:
                tree.add_new_pair(parent_key, child_key)  
            elif tree.is_root(child_key):
                tree.add_parent(parent_key, child_key)
            # there is no case that child key is internal

        elif tree.is_root(parent_key):
            if tree.find_node(child_key) == None:
                tree.add_child(parent_key, child_key)
            elif tree.is_root(child_key):
                tree.join(parent_key, child_key)
                
        elif tree.is_internal(parent_key):
            if tree.find_node(child_key) == None:
                tree.add_child(parent_key, child_key)
            elif tree.is_root(child_key):
                tree.join(parent_key, child_key)             

    first_common, *_ = [i for i in tree.parent(target1) if i in tree.parent(target2)]
    num_subtree = len(tree.children(first_common))
    print(f'#{case_num + 1} {first_common} {num_subtree}')