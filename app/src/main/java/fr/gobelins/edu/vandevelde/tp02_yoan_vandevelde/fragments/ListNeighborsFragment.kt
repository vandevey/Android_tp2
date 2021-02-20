package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.ListNeighborsAdapter
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.NavigationListener
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.R
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data.NeighborRepository
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.databinding.ListNeighborsFragmentBinding
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.models.Neighbor

class ListNeighborsFragment : Fragment(), CRUD<Neighbor>{


    // lateinit permet d'indiquer au compilateur que la variable sera initialisé plus tard -> Dans le onCreateView
    private lateinit var binding: ListNeighborsFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationListener) {
            context.updateTitle(R.string.title_neighbor_list)
        }
    }

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
        val adapter = ListNeighborsAdapter(neighbors, this)
        binding.neighborsList.adapter = adapter

        addButtonClick()
    }

    override fun onDeleteNeibor(model: Neighbor) {
        NeighborRepository.getInstance().delete(model)
    }

    fun addButtonClick() {
        binding.addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }
        }
    }


}