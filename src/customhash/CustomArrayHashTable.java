package customhash;

public class CustomArrayHashTable implements IndexInterface {
	private Integer table[]; // Integer hash table
	int numItems; // 当前哈希表中存储的元素数量

	// These are global variables representing DELETE and NOT_FOUND. 
	// DELETE: 用于表示删除操作后的位置标记。
	// NOT_FOUND: 用于表示查找操作失败时的返回值。
	static final Integer DELETED = -12345, NOT_FOUND = -1; 
	
	// Constructor 1: Creating an empty array hash table with the size of n.
	// 构造函数：创建一个大小为 n 的空哈希表，并将所有槽初始化为 null。
	public CustomArrayHashTable(int n) {
		table = new Integer[n]; // 初始化哈希表数组
		numItems = 0; // 初始元素数量为 0
	 	for (int i = 0; i < n; i++) table[i] = null; // 每个槽的初始值为 null
	}

	// Hash function: we only consider this hash function for implementation.
	// 哈希函数：实现线性探测法，用于计算元素的哈希位置。
	// h_i(x) = (h(x) + ai + b) % m
	// h(x) 是基本哈希函数，计算方法为 x % 13
	// 线性探测的增量参数：a = 1, b = 0
	private int hash(int i, Integer x) {
		// 计算当前元素在第 i 次探测时的位置
		return (x % 13 + i) % table.length;
	}
	
	// Implementation of insert(): Inserting a key value with x into the hash table.
	// 插入方法：将键值 x 插入哈希表。
	// 如果哈希表满，返回 -1。
	// 如果有空闲槽位，使用哈希函数计算位置并插入键值，返回 0。
	public int insert(Integer x) {
		int i = 0; // 探测次数初始化为 0
		while (i < table.length) { // 最多探测表中每个槽位
			int index = hash(i, x); // 计算探测的槽位索引
			// 插入条件：槽位为空（null）或为标记删除状态（DELETED）
			if (table[index] == null || table[index] == DELETED) {
				table[index] = x; // 将 x 插入到找到的位置
				numItems++; // 更新当前元素数量
				return 0; // 插入成功
			}
			i++; // 探测次数加 1
		}
		// 如果探测完成后仍无法找到合适位置，表示哈希表已满
		return -1;
	} 
 
	// Implementation of search(): Searching a key value with x from the hash table.
	// 查找方法：从哈希表中查找键值 x。
	// 如果找到，返回键值所在的索引。
	// 如果未找到，返回全局变量 NOT_FOUND。
	public Integer search(Integer x) {
		int i = 0; // 探测次数初始化为 0
		while (i < table.length) { // 最多探测表中每个槽位
			int index = hash(i, x); // 计算探测的槽位索引
			// 检查槽位是否为目标值 x
			if (table[index] != null && table[index].equals(x)) {
				return index; // 返回 x 所在的索引
			}
			// 提前结束条件：如果槽位为空，说明 x 不可能在后续探测中找到
			if (table[index] == null) break;
			i++; // 探测次数加 1
		}
		return NOT_FOUND; // 如果未找到，返回 NOT_FOUND
	}
	
	// Implementation of delete(): Deleting a key value with x from the hash table.
	// 删除方法：从哈希表中删除键值 x。
	// 如果找到 x，则用全局变量 DELETED 标记删除的位置。
	// 如果未找到，直接返回。
	public void delete(Integer x) {
		int i = 0; // 探测次数初始化为 0
		while (i < table.length) { // 最多探测表中每个槽位
			int index = hash(i, x); // 计算探测的槽位索引
			// 检查槽位是否为目标值 x
			if (table[index] != null && table[index].equals(x)) {
				table[index] = DELETED; // 标记槽位为删除状态
				numItems--; // 更新当前元素数量
				return; // 提前退出
			}
			// 提前结束条件：如果槽位为空，说明 x 不可能在后续探测中找到
			if (table[index] == null) return;
			i++; // 探测次数加 1
		}
	}

	// Implementation of isEmpty(): Check whether the hash table is empty.
	// 判断哈希表是否为空。
	// 如果当前元素数量为 0，则返回 true；否则返回 false。
 	public boolean isEmpty() {
		return numItems == 0; // 如果 numItems 为 0，返回 true
 	}
	
	// Implementation of clear(): Clear the hash table.
	// 清空方法：将哈希表的所有槽位重置为 null。
	// 同时将当前元素数量置为 0。
 	public void clear() {
		for (int i = 0; i < table.length; i++) {
			table[i] = null; // 重置每个槽位为 null
		}
		numItems = 0; // 将元素数量置为 0
 	 }
	
	// 获取指定索引位置的值。
	public Integer getItem(Integer i) {
		return table[i];
	}

	// 打印哈希表的当前状态。
	public void printAll() {
		System.out.println("Slots:"); 
		for (int i = 0; i < table.length; i++) {
			System.out.println("   " + i + ": " + table[i]);
		}
	}
}

