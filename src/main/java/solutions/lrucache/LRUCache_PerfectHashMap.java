package solutions.lrucache;

// http://javatroops.blogspot.com/2012/11/lru-cache-implementation-o1.html
//This is better https://alaindefrance.wordpress.com/2014/10/05/lru-cache-implementation/
//This one uses jdk libraries http://www.codewalk.com/2012/04/least-recently-used-lru-cache-implementation-java.html
//Study LinkedHashMap
public class LRUCache_PerfectHashMap {
    
        public static void main(String[] args) {
            PerfectHashMap map = new PerfectHashMap();
            map.put(10, "Ten");
            map.put(20, "Twenty");
            map.put(21, "Twenty One");
            map.put(30, "Thirty");
            map.put(1, "One");
            map.put(19, "Nineteen");
            map.put(33, "Thirty Three");
            map.put(23, "Twenty Three");
            map.put(66, "Sixty Six");
            map.put(0, "Zero");
            
            System.out.println("Head=" + map.linkedList.head + "; Tail=" +map.linkedList.tail);
            System.out.println(map.get(21));
            System.out.println("Head=" + map.linkedList.head + "; Tail=" +map.linkedList.tail);
            
            map.put( 55, "Fifty Five");
            System.out.println("Head=" + map.linkedList.head + "; Tail=" +map.linkedList.tail);
            
            map.remove(55);
            System.out.println("Head=" + map.linkedList.head + "; Tail=" +map.linkedList.tail);
        }
    }
    
    
    class PerfectHashMap {
        int MAX_SIZE = 10;
        float MAX_LOAD_FACTOR = 0.5f;
        
        int capacity1 = 11; //Choose a Prime
        int size1 = 0;
        float loadFactor1 = 0.0f; //loadfactor = (size/capacity)
        
        int capacity2 = 11; //Choose a Prime
        int size2 = 0;
        float loadFactor2 = 0.0f;
        
        Pair[] table1 = new Pair[capacity1];
        Pair[] table2 = new Pair[capacity2];
        LinkedList linkedList = new LinkedList();
            
        
        public void remove( Integer key ) {
            int h1 = hash1( key );
            int h2 = hash2( key );
            Pair pair1 = table1[h1];
            Pair pair2 = table2[h2];
            
            if( pair1 != null && pair1.key.equals(key) ) {	
                linkedList.remove(pair1.val);			
            } else if( pair2 != null && pair2.key.equals(key) ) {
                linkedList.remove(pair2.val);
            } 
        }
        
        public Pair get( Integer key ) {
            int h1 = hash1( key );
            int h2 = hash2( key );
            Pair pair1 = table1[h1];
            Pair pair2 = table2[h2];
            
            if( pair1 != null && pair1.key.equals(key) ) {	
                linkedList.moveToHead(pair1.val);
                return pair1;
            } else if( pair2 != null && pair2.key.equals(key) ) {
                linkedList.moveToHead(pair2.val);
                return pair2;
            } 
            return null;
        }
        
        public void put( Integer key, String val ) {
            int h1 = hash1( key );
            int h2 = hash2( key );
            if( slot1Empty(h1) ) {
                addTable1( key, val, h1 );
            } else if( slot2Empty(h2) ) {
                addTable2( key, val, h2 );
            } else {
                boolean pass = false;
                Integer original = key;
                Pair pushed = null; //Pushed out key
                Pair pair = null;
                while( true ) {
                    pushed = getTable1( h1 );
                    if( pushed == null ) {
                        break;
                    }
                    if( pass && (original.equals(key)) ) {
                        System.out.println("Found a Cycle and breaking. Key = " +key);
                        break;
                    }
                    if( key.equals(original) ) {
                        addTable1( key, val, h1 );
                    } else {
                        addTable1( pair, h1 );
                    }
                    h2 = hash2( pushed.key );	
                    pair  = getTable2( h2 );
                    addTable2( pushed, h2 );
                    if( pair == null ) {
                        break;
                    }
                    key = pair.key;
                    h1 = hash1( key );
                    pass = true;
                }
            }
        }
        
        public Pair getTable1( int index ) {
            return table1[ index ];
        }
        
        public Pair getTable2( int index ) {
            return table2[ index ];
        }
        
        /**
         * Add the number to the table. It could be replace or add.
         * If its add, then increment size. Once added, check the loadfactor.
         * If loadfactor is greater than 0.5f then double the capacity and
         * move the array contents to the new array
         * 
         * @param key
         * @param index
         */	
        public void addTable1( Integer key, String val, int index ) {
            if( getTable1(index) == null ) {
                if( size() == MAX_SIZE ) {
                    linkedList.removeTail();
                }
                size1++;
                loadFactor1 = size1/(float)capacity1;
                //Comment this if block: to simulate Cycle
                if( loadFactor1 >= MAX_LOAD_FACTOR ) {
                    int newCapacity = capacity1 * 2;
                    capacity1 = newCapacity;
                    Pair[] temp = new Pair[newCapacity];
                    System.arraycopy(table1, 0, temp, 0, table1.length);
                    table1 = temp;
                    temp = null;
                    index = hash1(key);				
                }
            }
            Node node = new Node(val);
            linkedList.insertHead(node );
            Pair pair = new Pair( key, node );
            table1[index] = pair;
        }
        
        public void addTable1( Pair pair, int index ) {
            if( getTable1(index) == null ) {
                if( size() == MAX_SIZE ) {
                    linkedList.removeTail();
                }
                size1++;
                loadFactor1 = size1/(float)capacity1;
                //Comment this if block: to simulate Cycle
                if( loadFactor1 >= MAX_LOAD_FACTOR ) {
                    int newCapacity = capacity1 * 2;
                    capacity1 = newCapacity;
                    Pair[] temp = new Pair[newCapacity];
                    System.arraycopy(table1, 0, temp, 0, table1.length);
                    table1 = temp;
                    temp = null;
                    index = hash1(pair.key);				
                }
            }
            table1[index] = pair;
        }	
    
        /**
         * Add the number to the table. It could be replace or add.
         * If its add, then increment size. Once added, check the loadfactor.
         * If loadfactor is greater than 0.5f then double the capacity and
         * move the array contents to the new array
         * 
         * @param key
         * @param index
         */
        public void addTable2( Integer key, String val, int index ) {
            if( getTable2(index) == null ) {
                if( size() == MAX_SIZE ) {
                    linkedList.removeTail();
                }
                size2++;
                loadFactor2 = size2/(float)capacity2;	
                //Comment this if block: to simulate Cycle
                if( loadFactor2 >= MAX_LOAD_FACTOR ) {
                    int newCapacity = capacity2 * 2;
                    capacity2 = newCapacity;
                    Pair[] temp = new Pair[newCapacity];
                    System.arraycopy(table2, 0, temp, 0, table2.length);
                    table2 = temp;
                    temp = null;
                    index = hash2(key);
                }
                
            }
            Node node = new Node(val);
            linkedList.insertHead(node );
            Pair pair = new Pair( key, node );
            table2[index] = pair;		
        }
        
        
        public void addTable2( Pair pair, int index ) {
            if( getTable2(index) == null ) {
                if( size() == MAX_SIZE ) {
                    linkedList.removeTail();
                }
                size2++;
                loadFactor2 = size2/(float)capacity2;	
                //Comment this if block: to simulate Cycle
                if( loadFactor2 >= MAX_LOAD_FACTOR ) {
                    int newCapacity = capacity2 * 2;
                    capacity2 = newCapacity;
                    Pair[] temp = new Pair[newCapacity];
                    System.arraycopy(table2, 0, temp, 0, table2.length);
                    table2 = temp;
                    temp = null;
                    index = hash2(pair.key);
                }
                
            }		
            table2[index] = pair;		
        }	
        
        public boolean slot1Empty( int index ) {
            return (table1[index] == null);
        }
    
        public boolean slot2Empty( int index ) {
            return (table2[index] == null);
        }
    
        
        public int hash1( int key ) {
            return ( key % capacity1 );
        }
        
        public int hash2( int key ) {
            return ( ( key / capacity2 ) % capacity2 );
        }	
        
        public int size() {
            return size1 + size2;
        }
    }
    
    class Pair {
        Integer key;	
        Node val;
        
        public Pair( Integer key, Node val ) {
            this.key = key;
            this.val = val;
        }
        
        public String toString() {
            return key.intValue() + " , " +val.val;
        }
    }
    
    class Node {
        String val;
        Node left;
        Node right;
        
        public Node( String val ) {
            this.val = val;
        }
        
        public String toString() {
            return val;
        }
    }
    
    class LinkedList {
        Node head;
        Node tail;
        
        public void insertHead( Node node ) {
            if( head == null ) {
                head = node;		
                tail = node;
                head.right = null;
            } else {
                node.right = head;
                head.left = node;
                head = node;
            }
        }
        
        public void removeTail() {
            Node node = tail.left;
            node.right = null;
            tail = node;
        }
        
        public void moveToHead( Node node ) {
            if( node != head ) {
                node.left.right = node.right;
                node.right = head;
                head.left = node;
                head = node;
                node.left = null;
            }
        }
        
        public void remove( Node node ) {
            if(node == head ) {
                head = node.right;
                node =null;
            } else {
                node.left.right = node.right;
                node = null;
            }
        }
    }
