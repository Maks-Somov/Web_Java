package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Maks
 * 06.02.2020.
 */
public class ArrayStorage implements IStorage {
    public static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    //    protected Logger LOGGER = Logger.getLogger(getClass().getName());
    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName());
    private int size;

    @Override
    public void clear() {
        LOGGER.info("Delete all resumes.");
        Arrays.fill(array, null);
        /*for(int i=0; i<LIMIT;i++){
            array[i]=null;
        }*/
        size = 0;
    }

    @Override
    public void save(Resume r) {
        LOGGER.info("Save resumes with uuid"+r.getUuid());
        int idx = getIndex(r.getUuid());


           /* try {
                throw new MainExeption("Resume " + r.getUuid() + "already exist " , r);
            } catch (MainExeption mainExeption) {
                mainExeption.printStackTrace();
            LOGGER.log(Level.SEVERE, mainExeption.getMessage(),mainExeption);
            throw new IllegalStateException(mainExeption);
            }*/
            if(idx!=-1)  throw new MainExeption("Resume " + r.getUuid() + "already exist ", r);
            array[size++]=r;
       /* for (int i = 0; i < LIMIT; i++) {
            if (array[i] == null) {
                array[i] = r;
            }
        }*/
    }

    @Override
    public void update(Resume r) {
        /*for (int i = 0; i < LIMIT; i++) {
            Resume resume = array[i];
            if (r.equals(resume)) {
                array[i] = r;
            }
        }*/
        LOGGER.info("Update resumes with "+r.getUuid());
        int idx = getIndex(r.getUuid());
        if(idx==-1) throw new MainExeption("Resume " + r.getUuid() + "not exist ", r);
        array[idx]=r;
    }

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resumes with uuid"+uuid);
        int idx = getIndex(uuid);
        if(idx==-1)    throw new MainExeption("Resume " + uuid + "not exist " );
         return array[idx];
    }

    @Override
    public void delete(String uuid) {
       /* for (int i = 0; i < array.length; i++) {
            if (array[i].equals(uuid)) {
                array[i] = null;
                break;
            }
        }*/
        LOGGER.info("Load resumes with uuid"+uuid);
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
    public Collection<Resume> getAllSorted() {
         Arrays.sort(array,0,size);
         return Arrays.asList(Arrays.copyOf(array,size));
    }

    @Override
    public int size() {
        return size;
    }

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

}
