package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.NavigationListener
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.R
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.data.NeighborRepository
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.databinding.AddNeighborBinding
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.models.Neighbor
import java.util.*

class AddNeighbourFragment : Fragment() {
    private var _binding: AddNeighborBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationListener) {
            context.updateTitle(R.string.title_neighbor_add)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = AddNeighborBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        submitButtonClick()
    }

    private fun submitButtonClick() {
        binding.submitButton.setOnClickListener(View.OnClickListener {


            val newNeigbor = Neighbor(
                    UUID.randomUUID().getMostSignificantBits(),
                    binding.nameInput.text.toString(),
                    binding.imageInput.text.toString(),
                    binding.addressInput.text.toString(),
                    binding.phoneInput.text.toString(),
                    binding.aboutInput.text.toString(),
                    false,
                    binding.websiteInput.text.toString()
            )

            NeighborRepository.getInstance().create(newNeigbor)
            print("After created neighbor")


        })
    }

}