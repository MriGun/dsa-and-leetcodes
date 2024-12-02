package com.mricode.leetcode.dsa.stacks;

public class DynamicStack extends CustomStack{

    public DynamicStack() {
        super(); //it will call CustomStack()
    }

    public DynamicStack(int size) {
        super(size); //it will call public CustomStack(int size)
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            //double array size
           int[] temp = new int[data.length * 2];

           //copy all items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            //System.arraycopy(data, 0, temp, 0, data.length);

            data = temp;
        }
    }
}
