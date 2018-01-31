package hashing;

/**
 * Created by ts250370 on 7/28/17.
 */
public class Dictionary {
    //Convert key to Integer.... 
        //a0 + a1.x + a2.x^2...... (a0, a1 are ascii of key char) and x is constant 37, 39, or 41
    //Compress key to map to one of the m slots of hash table
        // k mod m : m should not be power of 2 otherwise we will be only considering last power (2^10: last 10) bits
        // [ak mod 1] * m : a is number between 0 to 1. mod 1 will take only fraction part and floor of mult m will map
        // [ak + b] mod m : a should not be multiple of m otherwise everything will map to b
    //open addresseing: put all keys in array only not in linked list. n must be <= m
        //liner probing: if table[probe] == null then table[probe] = key else probe++ and check
        //double hashing: h1 to map to probe location and h2 for offset
            //table[probe + offset] == null add otherwise probe= probe + offset and check again
            //offset must be prime number to wrap last location properly otherwise if will be checking same locations in loop

}
