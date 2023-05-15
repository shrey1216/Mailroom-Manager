//@author Shreyan Wankavala

public class PackageStack {

    private Package stack[];
    private int size;
    private final int CAPACITY = 7;

    /** A constructor which initializes a new stack with size 0 and capacity 7
     *
     */
    public PackageStack(){
        this.stack = new Package[CAPACITY];
        this.size = 0;
    }

    /** A constructor with a parameter which initializes a new stack with a size and capacity 100
     *
     * @param size = the starting size of the stack.
     */
    public PackageStack(int size){
        this.stack = new Package[100];
        this.size = size;
    }

    /** Pushes a package onto the end of a stack
     *
     * @param x = the package that is going to be pushed
     */
    public void push(Package x){
        if(isFull()){
            throw new RuntimeException("\nThe stack is full!\n");
        }
        stack[size] = x;
        size++;
    }

    /** Pushes a package onto the end of a stack for when there is no capacity limit
     *
     * @param x = the package that is going to be pushed
     */
    public void pushFloor(Package x){
        stack[size] = x;
        size++;
    }

    /** Removes the package at the end of a stack and returns it
     *
     * @return the package that was removed from the end of the stack
     */
    public Package pop(){
        if(isEmpty()){
            throw new RuntimeException("\nThe stack is empty!\n");
        }
        return stack[--size];
    }

    /** Returns the package at the end of the stack without removing it
     *
     * @return the package at the end of the stack
     */
    public Package peek(){
        return stack[size-1];

    }

    /** Returns true if a stack is full
     *
     * @return true or false
     */
    public boolean isFull(){
        if(size == CAPACITY){
            return true;
        }
        else {
            return false;
        }
    }

    /** Returns true if a stack is empty
     *
     * @return true or false
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    /** Gets the package at a given index in a stack
     *
     * @param i  =  the index of the package
     * @return the package at that index
     */
    public Package getVal(int i){
        return stack[i];
    }

    /** Returns the size of the package
     *
     * @return the size
     */
    public int getSize(){
        return this.size;
    }


}
