package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data.datasource

import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.models.Neighbor

interface NeighborDataSource {
    /**
     * Get all my Neighbors
     * @return [List]
     */
    val neighbors: List<Neighbor>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbor(neighbor: Neighbor)

    /**
     * Create a neighbour
     * @param neighbor: Neighbor
     */
    fun createNeighbor(neighbor: Neighbor)

    /**
     * Update "Favorite status" of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateNeighbor(neighbor: Neighbor)
}