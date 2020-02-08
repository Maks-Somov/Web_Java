package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Maks
 * 06.02.2020.
 */
public class ArrayStorage extends AbstractStorage {
    public static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    //    protected Logger LOGGER = Logger.getLogger(getClass().getName());
//    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName());
    private int size=0;

    private int getIndex(String uuid){
        for (int i = 0; i<LIMIT;i++){
            if(array[i]!=null){
                if(array[i].getUuid().equals(uuid)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    protected void doSave(Resume r) {
        int idx = getIndex(r.getUuid());
        if(idx!=-1)  throw new MainExeption("Resume " + r.getUuid() + "already exist ", r);
        array[size++]=r;
    }

    @Override
    protected void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume r) {
        int idx = getIndex(r.getUuid());
        if(idx==-1) throw new MainExeption("Resume " + r.getUuid() + "not exist ", r);
        array[idx]=r;
    }

    @Override
    protected Resume doLoad(String uuid) {
        int idx = getIndex(uuid);
        if(idx==-1)    throw new MainExeption("Resume " + uuid + "not exist " );
        return array[idx];
    }

    @Override
    protected void doDelete(String uuid) {
        int idx = getIndex(uuid);
        if(idx==-1)
            throw new MainExeption("Resume " + uuid + "not exist " );
        int numMoved = size - idx - 1;
        if (numMoved > 0)
            System.arraycopy(array, idx+1, array, idx,
                    numMoved);
        array[--size] = null;
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        Arrays.sort(array,0,size);
        return Arrays.asList(Arrays.copyOf(array,size));
    }

    @Override
    protected int doSize() {
        return size;
    }

    @Override
    protected boolean exist(String uuid) {
        return getIndex(uuid)!=-1;
    }
}





