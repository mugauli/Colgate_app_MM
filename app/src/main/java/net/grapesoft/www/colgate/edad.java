package net.grapesoft.www.colgate;

/**
 * Created by Mugauli on 07/07/2016.
 */
public class edad {
        int id;
        String edad;
        //Constructor
        public edad(int id, String edad) {
            super();
            this.id = id;
            this.edad = edad;
        }
        @Override
        public String toString() {
            return edad;
        }
        public int getId() {
            return id;
        }
    }