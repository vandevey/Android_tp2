package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.ListNeighborsAdapter
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data.NeighborRepository
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.databinding.ListNeighborsFragmentBinding

class ListNeighborsFragment : Fragment(){


    // lateinit permet d'indiquer au compilateur que la variable sera initialisé plus tard -> Dans le onCreateView
    private lateinit var binding: ListNeighborsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListNeighborsFragmentBinding.inflate(inflater, container, false)
        binding.neighborsList.layoutManager = LinearLayoutManager(context)
        binding.neighborsList.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors)
        binding.neighborsList.adapter = adapter
    }
}