package com.example.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/*
we do this for creating a room database
first add the room data base dependencies along with coroutine dependencies
The create the room data base
then add tables to it
* for adding hilt to your project
* 1--> add all the required dependencies in build.gradle file
* 2--> create a general class and extend it from the Application class
*       2.1--> add the @HiltAndroidApp annotation before this class
* 3--> Register this activity in AndroidManifest file android:name=".$class name"
* 4--> create a module(i.e object) with these to annotations
*       used to add binding to hilt
*       4.1--> @InstallIn(SingletonComponent::class)
        4.2--> @Module
* 5--> Now in main activity, add @AndroidEntryPoint annotation before main activity
* */

@HiltAndroidApp
class NoteApplication:Application() {

}

