package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data

import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data.datasource.InMemoryNeighborDataSource
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data.datasource.NeighborDataSource
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.models.Neighbor

class NeighborRepository {
    private val dataSource: NeighborDataSource

    init {
        dataSource = InMemoryNeighborDataSource()
    }

    // Méthode qui retourne la liste des voisins
    fun getNeighbours(): MutableList<Neighbor> = dataSource.neighbors

    companion object {
        private var instance: NeighborRepository? = null

        // On crée un méthode qui retourne l'instance courante du repository si elle existe ou en crée une nouvelle sinon
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }

    fun delete(neighbor: Neighbor) {
        dataSource.deleteNeighbor(neighbor)
    }
}