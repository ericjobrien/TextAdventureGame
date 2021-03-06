package com.revature.collections;


import java.util.Arrays;
import java.util.InputMismatchException;

public class GenericArrayList<T> {

    private T[] genericArray;
    private Integer length;

    public GenericArrayList() {
    }

    public GenericArrayList(T[] genericArray) {
        this.genericArray = genericArray;

    }

    public T[] getGenericArray() {
        return genericArray;
    }

    public void setGenericArray(T[] genericArray) {
        this.genericArray = genericArray;
    }

    public Integer getLength() {
        return this.genericArray.length;
    }


    @Override
    public String toString() {
        return "GenericArrayList{" +
                "genericArray=" + Arrays.toString(genericArray) +
                ", length=" + genericArray.length +
                '}';
    }

    public T getElementAtIndex(int index) {

        return this.genericArray[index];
    }

    public Integer getIndexOfFirstNull(T[] genericArray) {

        /*
        This helper method finds the first null value.
        If the returned value is the same as the length of the given array, there is no null value present.
         */

        Integer counter = 0;

        for(int i = 0; i < genericArray.length; i++) {
            if(genericArray[i] != null) {
                counter ++;
            } else {
                return counter;
            }
        }

        return counter;
    }

    public T[] addElement(T element)  {

        T[] genericArray = this.genericArray;

        Integer currentLength = this.getIndexOfFirstNull(genericArray);

        if (currentLength >= genericArray.length) {
            T[] newGenericArray = (T[]) new Object[currentLength * 2];

            for (int i = 0; i < genericArray.length; i++) {
                newGenericArray[i] = genericArray[i];
            }
            for (int j = 0; j < newGenericArray.length; j++) {
                if (newGenericArray[j] == null) {
                    currentLength = j;
                    newGenericArray[j] = element;
                    break;
                }
            }
            return newGenericArray;
        } else {
            genericArray[currentLength] = element;
        }

        return genericArray;
    }

    public T[] expandArray(T[] genericArray) {

        /*
        This function automatically doubles the size of an array.
        This can be useful, if you know there is no more room in an array.
        You can use this method first, then use the addToArray helper method
        for quick insertion into an array.
         */

        Integer length = genericArray.length;

        GenericArrayList genericArrayList = new GenericArrayList(genericArray);
        Integer number = genericArrayList.getIndexOfFirstNull(genericArray);

        Object[] newGenericArray = new Object[length * 2];
        System.out.println(newGenericArray.length);

        for(int i = 0; i < length; i++) {
            newGenericArray[i] = genericArray[i];
        }
        genericArray = (T[]) newGenericArray;


        return genericArray;

    }

    public void addToArray(T element, T[] genericArray) {

         /*
         Use this function when you know there is a null value present in an array.
         This is a quick add feature, as it will bypass having to pass data from an array to a new generic array while null values are present in an array.
         You can use the findFirstNull helper method in this class to determine if an array has a null value.
         You can alternatively use the isPresent method to determine if a null value is present as well.
         It will not expand the array and therefore cannot be used if there are no null values currently in an array.

         */

        Integer length = genericArray.length;
        GenericArrayList genericArrayList = new GenericArrayList(genericArray);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Array must be expanded before accepting additional elements");
        Integer indexOfFirstNull = this.getIndexOfFirstNull(genericArray);

        if (indexOfFirstNull == length) {
            throw indexOutOfBoundsException;
        } else {
            Object[] newArray = genericArrayList.addElement(element);
            genericArray = (T[]) newArray;

        }

    }

    public T getValueFromIndex(int index) {
        return this.genericArray[index];
    }

    public Boolean isPresent(T element) {

        /*
        Use this to determine if a value is currently present in the underlying array.
        You first have to pass the array to a GenericArrayList, to ensure the array being transversed
        contains all the elements in the underlying array.
         */

        T checkElement;
        for(int i = 0; i < this.genericArray.length; i++) {
            checkElement = this.genericArray[i];

            while(!this.genericArray[i].equals(null)) {
                if(this.genericArray[i].equals(element)) {
                    return true;
                } else {
                    break;
                }
            }
        }


        return false;
    }

    public static String genericToString(GenericArrayList genericArrayList) {

        Object[] array = genericArrayList.genericArray;
        StringBuilder stringBuilder = new StringBuilder();
        for(Object element : array) {
            stringBuilder.append("[" + element + "], ");
        }
        String string = stringBuilder.toString();
        return string;
    }


}
