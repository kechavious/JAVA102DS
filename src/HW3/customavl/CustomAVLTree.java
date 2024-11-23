package customavl;

import java.util.List;
import java.util.ArrayList;

public class CustomAVLTree implements IndexInterface<AVLNode> {
    private AVLNode root;

    // NIL 是一个特殊节点，用于表示树的空节点。它的值为null，但高度为0，用于计算父节点的高度
    static final AVLNode NIL = new AVLNode(null, null, null, 0);

    // 用于存储前序遍历的打印输出
    public List<Comparable> tree_print;

    // 构造函数1：创建一个空的AVL树
    public CustomAVLTree() {
        root = NIL;
    }

    // search方法：在AVL树中查找指定键值
    public AVLNode search(Comparable x) {
        return searchItem(root, x);
    }

    // searchItem方法：递归查找键值，匹配则返回节点，不存在则返回null
    private AVLNode searchItem(AVLNode tNode, Comparable x) {
        if (tNode == NIL) {
            return null; // 如果达到NIL节点，则查找失败
        } else if (tNode.item.compareTo(x) == 0) {
            return tNode; // 找到节点，返回该节点
        } else if (tNode.item.compareTo(x) > 0) {
            return searchItem(tNode.left, x); // 递归查找左子树
        } else {
            return searchItem(tNode.right, x); // 递归查找右子树
        }
    }

    // insert方法：向AVL树中插入新键值
    public void insert(Comparable x) {
        root = insertItem(root, x);
    }

    // insertItem方法：递归插入节点，同时检查并调整平衡
    private AVLNode insertItem(AVLNode tNode, Comparable x) {
        if (tNode == NIL) {
            return new AVLNode(x, NIL, NIL, 1); // 到达空位置，创建新节点
        }
        if (tNode.item.compareTo(x) > 0) {
            tNode.left = insertItem(tNode.left, x); // 插入到左子树
        } else {
            tNode.right = insertItem(tNode.right, x); // 插入到右子树
        }
        // 更新当前节点的高度
        tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
        // 调用平衡函数以确保AVL属性
        return balanceAVL(tNode, needBalance(tNode));
    }

    // delete方法：从AVL树中删除指定键值
    public void delete(Comparable x) {
        root = deleteItem(root, x);
    }

    // deleteItem方法：递归删除节点，删除后更新高度并调整平衡
    private AVLNode deleteItem(AVLNode tNode, Comparable x) {
        if (tNode == NIL) {
            return tNode; // 没找到要删除的节点
        }
        if (tNode.item.compareTo(x) > 0) {
            tNode.left = deleteItem(tNode.left, x); // 从左子树查找
        } else if (tNode.item.compareTo(x) < 0) {
            tNode.right = deleteItem(tNode.right, x); // 从右子树查找
        } else {
            // 找到节点：根据子节点情况处理
            if (tNode.left == NIL || tNode.right == NIL) {
                // 如果节点没有或仅有一个子节点，直接替换
                tNode = (tNode.left != NIL) ? tNode.left : tNode.right;
            } else {
                // 有两个子节点时，寻找右子树的最小值节点并替换
                returnPair rp = deleteMinItem(tNode.right);
                tNode.item = rp.item;
                tNode.right = rp.node;
            }
        }
        if (tNode != NIL) {
            // 更新当前节点高度并平衡
            tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
            return balanceAVL(tNode, needBalance(tNode));
        }
        return tNode;
    }

    // deleteMinItem方法：从右子树中删除最小节点，用于替换删除节点
    private returnPair deleteMinItem(AVLNode tNode) {
        if (tNode.left == NIL) {
            return new returnPair(tNode.item, tNode.right); // 找到最小节点
        }
        returnPair rp = deleteMinItem(tNode.left);
        tNode.left = rp.node; // 更新左子树
        tNode.height = Math.max(tNode.left.height, tNode.right.height) + 1;
        return new returnPair(rp.item, balanceAVL(tNode, needBalance(tNode)));
    }

    private class returnPair {
        private Comparable item;
        private AVLNode node;
        private returnPair(Comparable it, AVLNode nd) {
            item = it;
            node = nd;
        }
    }

    // balanceAVL方法：根据需要的平衡类型调用左旋或右旋
    private AVLNode balanceAVL(AVLNode tNode, int type) {
        int balance = tNode.left.height - tNode.right.height;
        if (balance > 1) { // 左子树失衡
            if (tNode.left.left.height >= tNode.left.right.height) {
                return rightRotate(tNode); // LL情况，右旋
            } else {
                tNode.left = leftRotate(tNode.left); // LR情况，先左旋左子节点
                return rightRotate(tNode); // 然后右旋
            }
        } else if (balance < -1) { // 右子树失衡
            if (tNode.right.right.height >= tNode.right.left.height) {
                return leftRotate(tNode); // RR情况，左旋
            } else {
                tNode.right = rightRotate(tNode.right); // RL情况，先右旋右子节点
                return leftRotate(tNode); // 然后左旋
            }
        }
        return tNode; // 无需平衡
    }

    // 左旋操作
    private AVLNode leftRotate(AVLNode t) {
        AVLNode temp = t.right;
        t.right = temp.left;
        temp.left = t;
        // 更新高度
        t.height = Math.max(t.left.height, t.right.height) + 1;
        temp.height = Math.max(temp.left.height, temp.right.height) + 1;
        return temp;
    }

    // 右旋操作
    private AVLNode rightRotate(AVLNode t) {
        AVLNode temp = t.left;
        t.left = temp.right;
        temp.right = t;
        // 更新高度
        t.height = Math.max(t.left.height, t.right.height) + 1;
        temp.height = Math.max(temp.left.height, temp.right.height) + 1;
        return temp;
    }

    // 判断平衡需求：返回平衡类型（LL, LR, RR, RL等）
    private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;

    private int needBalance(AVLNode t) {
        int balance = t.left.height - t.right.height;
        if (balance > 1) {
            return (t.left.left.height >= t.left.right.height) ? LL : LR;
        } else if (balance < -1) {
            return (t.right.right.height >= t.right.left.height) ? RR : RL;
        }
        return NO_NEED;
    }

    // isEmpty方法：检查AVL树是否为空
    public boolean isEmpty() {
        return root == NIL;
    }
	
    // clear方法：清空AVL树
    public void clear() {
        root = NIL;
        tree_print = null;
    }

	//********************************************************************************************************************************************************//

    // 前序遍历键值
    public List printPreOrderKey() {
        tree_print = new ArrayList<>();
        prPreOrderKey(root);
        return tree_print;
    }

    private void prPreOrderKey(AVLNode tNode) {
        if (tNode != NIL) {
            tree_print.add(tNode.item);
            prPreOrderKey(tNode.left);
            prPreOrderKey(tNode.right);
        }
    }

    // 前序遍历高度
    public List printPreOrderHeight() {
        tree_print = new ArrayList<>();
        prPreOrderHeight(root);
        return tree_print;
    }

    private void prPreOrderHeight(AVLNode tNode) {
        if (tNode != NIL) {
            tree_print.add(tNode.height);
            prPreOrderHeight(tNode.left);
            prPreOrderHeight(tNode.right);
        }
    }
}
