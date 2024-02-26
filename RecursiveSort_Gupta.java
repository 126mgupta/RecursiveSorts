import ComplexSorts.QuickAndMergeSorts;
import ComplexSorts.QuickSort;
import java.util.List;

public class RecursiveSort_Gupta implements QuickAndMergeSorts {
    public <T extends Comparable<T> & Cloneable> T[] quickSort(T[] array) {
        return quickSort(array, 0, array.length);
    }

    public <T extends Comparable<T>& Cloneable> T[] quickSort(T[] array, int startIndex, int endIndex) {
        if (endIndex - startIndex < 2) {
            return array;
        }
        T splittingData = array[endIndex - 1];
        int splittingIndex = startIndex;
        for (int current = startIndex; current < endIndex - 1; current++) {
            if (array[current].compareTo(splittingData) <= 0) {
            T temp = array[current];
            array[current] = array[splittingIndex];
            array[splittingIndex] = temp;
            splittingIndex++;
            }
        }
        T temp = array[splittingIndex];
        array[splittingIndex] = array[endIndex-1];
        array[endIndex-1] = temp;
        array = quickSort(array, startIndex, splittingIndex);
        array = quickSort(array, splittingIndex+1, endIndex);
        return array;
    }

    public <T extends Comparable<T>& Cloneable> List<T> quickSort(List<T> list) {
        return quickSort(list, 0, list.size());
    }

    public <T extends Comparable<T>& Cloneable> List<T> quickSort(List<T> list, int startIndex, int endIndex) {
        if(endIndex - startIndex < 2) {
            return list;
        }
        T splittingData = list.get(endIndex-1);
        int splittingIndex = startIndex;
        for(int current = startIndex; current < endIndex-1; current++) {
            if(list.get(current).compareTo(splittingData) <= 0) {
                T temp = list.get(current);
                list.set(current, list.get(splittingIndex));
                list.set(splittingIndex, temp);
                splittingIndex++;
            }
        }
        T temp = list.get(splittingIndex);
        list.set(splittingIndex, list.get(endIndex-1));
        list.set(endIndex-1, temp);
        list = quickSort(list, startIndex, splittingIndex);
        list = quickSort(list, splittingIndex+1, endIndex);
        return list;
    }

    public <T extends Comparable<T>& Cloneable> T[] mergeSort(T[] array) {
        mergeSort(array, 0, array.length);
        return array;
    }

    public <T extends Comparable<T>& Cloneable> T[] mergeSort(T[] array, int startIndex, int endIndex) {
        int numElements = endIndex - startIndex;
        if(array.length <= 1) {
            return array;
        }
        int lengthLeft = numElements/2;
        int lengthRight = numElements - lengthLeft;
        int rightStartIndex = startIndex + lengthLeft;
        array = mergeSort(array, startIndex, rightStartIndex);
        array = mergeSort(array, rightStartIndex, endIndex);
        T[] copy = array.clone();
        int left = startIndex;
        int right = rightStartIndex;
        int index = startIndex;

        while(left < rightStartIndex && right < endIndex) {
            if (array[right].compareTo(array[left]) < 0) {
                copy[index] = copy[right];
                right++;
            } else {
                copy[index] = copy[left];
                left++;
            }
            index++;
        }
        while(left < rightStartIndex) {
            copy[index] = copy[left];
            left++;
            index++;
        }

        while(right < endIndex) {
            copy[index] = copy[right];
            right++;
            index++;
        }

        return copy;
    }

    public <T extends Comparable<T>& Cloneable> List<T> mergeSort(List<T> list) {
    return mergeSort(list, 0, list.size());
    }

    public <T extends Comparable<T>& Cloneable> List<T> mergeSort(List<T> list, int startIndex, int endIndex) {
        int numElements = endIndex - startIndex;
        if(numElements == 1) {
            return list;
        }
        int lengthLeft = numElements/2;
        int lengthRight = numElements - lengthLeft;
        int rightStartIndex = startIndex + lengthLeft;
        list = mergeSort(list, startIndex, rightStartIndex);
        list = mergeSort(list, rightStartIndex, endIndex);
        Object[] orig = list.toArray();
        int left = startIndex;
        int right = rightStartIndex;
        int index = startIndex;

        while(left < rightStartIndex && right < endIndex) {
            if(((T)orig[right]).compareTo((T)(orig[left])) < 0) {
                list.set(index, ((T) orig[right]));
                right++;
            } else {
                list.set(index, ((T)orig[left]));
                left++;
            }
            index++;
        }
        while(left < rightStartIndex) {
            list.set(index, ((T)orig[left]));
            left++;
            index++;
        }

        while(right < endIndex) {
            list.set(index, ((T)orig[right]));
            right++;
            index++;
        }

        return list;
    }
}
