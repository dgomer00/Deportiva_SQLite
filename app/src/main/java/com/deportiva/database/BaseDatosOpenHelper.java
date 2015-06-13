package com.deportiva.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by David on 03/04/2015.
 */
public class BaseDatosOpenHelper extends SQLiteOpenHelper {
    String tablaUsuarios ="CREATE TABLE Usuarios(Id INTEGER PRIMARY KEY AUTOINCREMENT, User TEXT NOT NULL, Password TEXT NOT NULL)";
    String tablaEquipos="CREATE TABLE Equipos(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL)";
    String tablaJugadores="CREATE TABLE Jugadores(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Nombre_completo TEXT NOT NULL, Posicion TEXT NOT NULL, Fecha_nacimiento DATETIME NOT NULL, Nacido TEXT NOT NULL, Peso FLOAT NOT NULL, Estatura FLOAT NOT NULL, Procedencia TEXT NOT NULL, Dorsal INTEGER NOT NULL, Id_equipo INTEGER NOT NULL)";

    public BaseDatosOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        * Creamos las tablas
        */
        db.execSQL(tablaUsuarios);
        db.execSQL(tablaEquipos);
        db.execSQL(tablaJugadores);

        /*
        * Ponemos los datos iniciales en la tabla de Usuarios
        */
        db.execSQL("INSERT INTO Usuarios(Id, User, Password) VALUES(1,'admin', '12345')");
        /*
        * Ponemos los datos iniciales en la tabla de Equipos
        */
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(1,'D. Alavés')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(2,'Albacete B.')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(3,'A.D. Alcorcón')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(4,'F.C. Barcelona b')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(5,'Real Betis')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(6,'Girona F.C.')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(7,'U.D. Las Palmas')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(8,'C.D. Leganés')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(9,'U.E LLagostera')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(10,'C.D. Lugo')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(11,'R.C.D. Mallorca')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(12,'C.D. Mirandés')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(13,'C.D. Numancia')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(14,'At. Osasuna')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(15,'S.D. Ponferradina')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(16,'R. Racing Club')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(17,'R.C. Recreativo')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(18,'C.E. Sabadell')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(19,'R. Sporting')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(20,'C.D. Tenerife')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(21,'R. Valladolid C.F.')");
        db.execSQL("INSERT INTO Equipos(Id, Nombre) VALUES(22,'R. Zaragoza')");
        /*
        * Ponemos los datos iniciales en la tabla de Jugadores de la S.D.Ponferradina.
        */
        //Los porteros de la S.D.Ponferradina
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(1, 'Dinu', 'Dinu Moldovan Bogdam', 'Portero', '1990-05-03', 'Albalulia(Rumanía)', 72, 1.83, 'S.D.Ponferradina', 25, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(2, 'Prieto', 'Francisco Javier Prieto Caroca', 'Portero', '1983-07-01', 'Antofagasta(Chile)', 79, 1.88, 'Mirandés', 13, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(3, 'Arrizabalaga', 'Kepa Arrizabalaga Revuelta', 'Portero', '1994-10-03', 'Ondárroa(Vizcaya)', 85, 1.89, 'Athletic Club', 1, 15)");
        //Los defensas de la S.D.Ponferradina
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(4, 'Carpio', 'Javier Carpio Martín', 'Defensa', '1984-04-06', 'Salamanca', 72, 1.75, 'S.D.Ponferradina', 2, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(5, 'Alan', 'Alan Baró Calabuig', 'Defensa', '1985-06-22', 'Darnius(Girona)', 73, 1.80, 'S.D.Ponferradina', 15, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(6, 'Lucas', 'Lucas Domínguez Irarrázabal', 'Defensa', '1989-10-27', 'Pirque(Chile)', 75, 1.86, 'Colo-Colo', 4, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(7, 'J.Castañeda', 'Julen Castañeda Nuin', 'Defensa', '1990-11-14', 'Tolosa', 75.5, 1.79, 'S.D.Ponferradina', 3, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(8, 'Camille', 'Samuel Camille Geoffroy', 'Defensa', '1986-02-02', 'Saint Denis(Francia)', 69, 1.76, 'A.D.Alcorcón', 24, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(9, 'O.Ramírez.J', 'Óscar Ramírez Martín', 'Defensa', '1984-03-01', 'Girona', 77, 1.83, 'S.D.Ponferradina', 20, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(10, 'Alberto A.', 'Alberto Aguilar Leiva', 'Defensa', '1984-07-12', 'Benamejí(Córdoba)', 80.5, 1.84, 'S.D.Ponferradina', 22, 15)");
        //Los centrocampistas de la S.D.Ponferradina
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(11, 'Jonathan', 'Jonathan Ruiz LLaga', 'Centrocampista', '1982-04-02', 'Écija(Sevilla)', 64, 1.70, 'S.D.Ponferradina', 14, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(12, 'Acorán', 'Acorán Barrera Reyes', 'Centrocampista', '1983-01-31', 'Tenerife', 68, 1.73, 'S.D.Ponferradina', 16, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(13, 'Rueda', 'José Manuel Rueda Sampedro', 'Centrocampista', '1988-01-30', 'Linares(Jaén)', 72.5, 1.78, 'S.D.Ponferradina', 8, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(14, 'Andy', 'José Andrés Rodríguez Gaitán', 'Centrocampista', '1990-01-30', 'Almuñecar(Granada)', 79, 1.85, 'Levante B', 17, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(15, 'Adán', 'Adán Gurdiel Mella', 'Centrocampista', '1993-12-14', 'Fabero(León)', 69, 1.78, 'S.D.Ponferradina', 26, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(16, 'Gaztañaga', 'Jon Gaztañaga Arrospide', 'Centrocampista', '1991-06-26', 'Andoáin(Guipúzcoa)', 80, 1.82, 'Real Sociedad', 6, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(17, 'Tete', 'Alberto Sansinena Chamorro', 'Centrocampista', '1985-05-26', 'Badajoz', 59, 1.66, 'Real Murcia', 19, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(18, 'Melero', 'Gonzalo Julián Melero Manzanares', 'Centrocampista', '1994-01-02', 'Madrid', 77, 1.83, 'Real Madrid Castilla', 23, 15)");
        //Los delanteros de la S.D.Ponferradina
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(19, 'R.Sobrino', 'Rubén Sobrino Pozuelo', 'Delantero', '1993-06-01', 'Ciudad Real', 75, 1.82, 'Real Madrid Castilla', 11, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(20, 'Cristian F.', 'Cristian Fernández Conchuela', 'Delantero', '1988-12-22', 'Guadalajara', 70, 1.78, 'S.D.Ponferradina', 7, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(21, 'Berrocal', 'Jesús Berrocal Campos', 'Delantero', '1988-02-05', 'Córdoba)', 77, 1.83, 'S.D.Ponferradina', 9, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(22, 'Pablo', 'Pablo Infante Muñoz', 'Delantero', '1980-03-20', 'Burgos', 70, 1.75, 'Mirandés', 21, 15)");
        db.execSQL("INSERT INTO Jugadores(Id, Nombre, Nombre_completo, Posicion, Fecha_nacimiento, Nacido, Peso, Estatura, Procedencia, Dorsal, Id_equipo) VALUES(23, 'Yuri', 'Yuri De Souza Fonseca', 'Delantero', '1982-08-08', 'Maceio(Brasil)', 78, 1.86, 'S.D.Ponferradina', 10, 15)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Usuarios");
        db.execSQL("DROP TABLE IF EXIST Equipos");
        db.execSQL("DROP TABLE IF EXIST Jugadores");
        db.execSQL(tablaUsuarios);
        db.execSQL(tablaEquipos);
        db.execSQL(tablaJugadores);
    }

       //Este método es utilizado para la comprobacion de usuario y contraseña para entrar a esta parte de la app, para poder modificar la base de datos.
    public boolean testCredentials(BaseDatosOpenHelper baseHelper,String user, String password){
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*)FROM Usuarios WHERE User='"+user+"' AND Password = '"+password+"'",null);

        if(cursor.getCount()<1){
            db.close();
            return false;
        }
        cursor.moveToFirst();
        if(cursor.getInt(0)!=1){
            db.close();
            return false;
        }
        cursor.close();
        db.close();
        return true;
    }

    //Este método se utiliza para la carga de los jugadores en la opcion de plantilla.
    public static String[] cargar(BaseDatosOpenHelper baseHelper, String nombre, int dorsal, int id_equipo){

        String[] jugador = new String[9];

        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Jugadores WHERE Nombre='"+nombre+"' AND Dorsal="+dorsal+" AND Id_equipo="+id_equipo, null);
            int cantidad = c.getCount();//Cantidad de registros

            if (cantidad==1 && c.moveToFirst()) {//Si la cantidad de registros es igual a 1 quiere decir que encontro al jugador y procedemos a rellenar el array
                    jugador[0]=c.getString(1);
                    jugador[1]=c.getString(2);
                    jugador[2]=c.getString(3);
                    jugador[3]=c.getString(4);
                    jugador[4]=c.getString(5);
                    jugador[5]=c.getString(6);
                    jugador[6]=c.getString(7);
                    jugador[7]=c.getString(8);
                    jugador[8]=c.getString(9);

                c.close();
                return jugador;

                }else if(cantidad==0){//Sino se encuentra el jugador se enviara en la primera posicion del array un mensaje.
                jugador[0]="Jugador Inexistente";
                return jugador;
            }else{//Si el numero de registros no es ni 0 ni 1, quiere decir que hay más de un jugador con el mismo nombre,dorsal y equipo, algo que es imposible puesto que los dorsales no se repiten.
                jugador[0]="Error";
                return jugador;
            }

        }

    return jugador;
    }
}