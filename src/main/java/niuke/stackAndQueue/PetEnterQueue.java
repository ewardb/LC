package niuke.stackAndQueue;

/**
 * Created by wq on 16-5-26.
 */
public class PetEnterQueue {
    private Pet pet;
    private int count;

    public PetEnterQueue(Pet pet,int count){
        this.pet = pet;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Pet getPet() {
        return pet;
    }

}
