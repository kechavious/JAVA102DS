package custombst;

import java.util.List;
import java.util.ArrayList;

public class CustomBinarySearchTree implements IndexInterface<TreeNode> {
	private TreeNode root;
	public List<Comparable> tree_print;

	// 构造函数 1：创建一个空的二叉搜索树（BST）。
	public CustomBinarySearchTree() { 
		root = null;
	}
	
	// search()的实现：在BST中搜索searchKey
	public TreeNode search(Comparable searchKey) {
		return searchItem(root, searchKey);
	}
	
	// 实现searchItem函数，递归地使用searchItem函数
	// 基于键值比较在左子树和右子树上执行递归搜索。
	// 如果搜索失败，返回null。
	// 如果搜索成功，返回对应的节点。
	private TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
		try{
			if (tNode == null) { // 如果节点为空，返回null
				return null;
			} else if (tNode.key.equals(searchKey)) { // 如果找到匹配的节点，返回该节点
				return tNode;
			} else if (tNode.key.compareTo(searchKey) < 0) { // 如果当前节点小于searchKey，递归右子树
				return searchItem(tNode.right, searchKey);
			} else { // 如果当前节点大于searchKey，递归左子树
				return searchItem(tNode.left, searchKey);
			}
		}catch(Exception e){
			return null;
		}
	}
	
	// insert()的实现：在BST中插入带有newKey的节点
	public void insert(Comparable newKey) {
		root = insertItem(root, newKey);
	}
 
	// 实现insertItem函数，递归地使用insertItem函数
	// 基于键值比较在左子树和右子树上执行递归搜索。
	// 当达到叶节点（或树为空）时，创建一个新节点并返回该节点。
	private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
		try{
			if(tNode == null){ // 如果节点为空，创建一个新节点并返回
				tNode = new TreeNode(newItem);
				tNode.left = null;
				tNode.right = null;
				return tNode;
			}else if(tNode.key.compareTo(newItem) < 0){ // 如果当前节点小于newItem，递归右子树
				tNode.right = insertItem(tNode.right, newItem);
				return tNode;
			}else{ // 如果当前节点大于newItem，递归左子树
				tNode.left = insertItem(tNode.left, newItem);
				return tNode;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	// delete()的实现：从BST中删除带有searchKey的节点
	public void delete(Comparable searchKey) {
		root = deleteItem(root, searchKey);
	}
	
	// 实现deleteItem函数，递归地使用deleteItem函数
	// 基于键值比较在左子树和右子树上执行递归搜索。
	// 如果搜索失败，返回null。
	// 如果搜索成功，调用deleteNode函数。
	// 最后，deleteItem在递归调用后返回根节点。
	private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
		try{
			if(tNode == null){ // 如果节点为空，返回null
				return null;
			}else if(tNode.key.compareTo(searchKey) < 0){ // 如果当前节点小于searchKey，递归右子树
				tNode.right = deleteItem(tNode.right, searchKey);
				return tNode;
			}else if(tNode.key.compareTo(searchKey) > 0){ // 如果当前节点大于searchKey，递归左子树
				tNode.left = deleteItem(tNode.left, searchKey);
				return tNode;
			}else{
				// 如果找到匹配的节点，调用deleteNode处理删除操作
				tNode= deleteNode(tNode);
				return tNode;
			}
		}catch(Exception e){
			return null;
		}
	}
 
	// 实现deleteNode函数，考虑三种情况
	// 1. 如果tNode是叶节点
	// 2. 如果tNode只有一个子节点。
	// 3. 如果tNode有两个子节点。
	// 对于情况3，调用deleteMinItem函数删除具有两个子节点的节点。
	private TreeNode deleteNode(TreeNode tNode) {
		if (tNode.left == null && tNode.right == null) {
			return null; // 叶子节点，直接删除
		} else if (tNode.left == null) {
			return tNode.right; // 只有右子节点，返回右子节点
		} else if (tNode.right == null) {
			return tNode.left; // 只有左子节点，返回左子节点
		} else {
			// 有两个子节点的情况
			returnPair minPair = deleteMinItem(tNode.right); // 从右子树中删除最小节点
			tNode.key = minPair.key; // 用右子树的最小节点的键值替换当前节点的键值
			tNode.right = minPair.node; // 更新右子树
			return tNode;
		}
	}
	
	// 实现deleteMinItem函数，使用returnPair返回最小键值和更新后的树。
	// 使用递归的deleteMinItem函数找到并删除最小节点。
	// 如果tNode.left == null，表示找到最小节点。
	private returnPair deleteMinItem(TreeNode tNode) {
		if(tNode.left == null){
			return new returnPair(tNode.key, tNode.right); // 找到最小节点，返回其键值和右子树
		}else{
			returnPair temp = deleteMinItem(tNode.left); // 递归左子树
			tNode.left = temp.node; // 更新左子树
			return new returnPair(temp.key, tNode); // 返回最小键值和更新后的树
		}
	}
	
	// returnPair类包含key和node变量
	// 它们分别通过传入的key和node进行初始化
	private class returnPair {
		private Comparable key;
		private TreeNode node;
		private returnPair(Comparable it, TreeNode nd) {
			key = it;
			node = nd;
		}
	}
	
	// isEmpty()的实现：检查BST是否为空
	// 如果BST为空，返回true
	// 否则返回false
	public boolean isEmpty() {
		return root == null;
	}
	
	// clear()的实现：清空BST
	public void clear() {
		root = null;
	}

	/////////////////////////////////////////////////
	// printPreOrder()的实现：前序遍历树并返回结果列表
	public List printPreOrder() {
		tree_print = new ArrayList<Comparable>();
		prPreOrder(root);
		return tree_print;
	}
	
	// prPreOrder()的实现：递归地前序遍历树
	public void prPreOrder(TreeNode tNode) {
		if (tNode != null) {
			tree_print.add(tNode.key); // 添加当前节点的键值
			prPreOrder(tNode.left); // 遍历左子树
			prPreOrder(tNode.right); // 遍历右子树
		}
	}
} 
