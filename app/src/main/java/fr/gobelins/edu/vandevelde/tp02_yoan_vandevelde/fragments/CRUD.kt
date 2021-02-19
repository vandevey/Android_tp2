package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments

import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.models.Neighbor

interface CRUD<Model> {

    fun onDeleteNeibor(model: Model)

}