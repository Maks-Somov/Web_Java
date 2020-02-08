package main.storage;

import main.MainExeption;
import main.model.Contact;
import main.model.ContactType;
import main.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayStorageTest extends AbstractStorageTest {
   {
      storage = new ArrayStorage();
   }
}