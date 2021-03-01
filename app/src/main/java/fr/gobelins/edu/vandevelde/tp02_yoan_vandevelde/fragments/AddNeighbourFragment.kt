package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.basgeekball.awesomevalidation.utility.RegexTemplate
import com.basgeekball.awesomevalidation.AwesomeValidation as Validation
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        submitButtonClick()
    }

    private fun submitButtonClick() {
        binding.submitButton.setOnClickListener(
                View.OnClickListener {
                    validator()

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
                }
        )
    }

    private fun validator() {
        val formValidation = Validation(ValidationStyle.COLORATION)

        formValidation.addValidation(activity, binding.nameInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_message)

        formValidation.addValidation(activity, binding.imageInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_message)
        formValidation.addValidation(activity, binding.imageInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_web_url)

        formValidation.addValidation(activity, binding.addressInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_web_url)

        formValidation.addValidation(activity, binding.phoneInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_message)
        formValidation.addValidation(activity, binding.phoneInput.id, android.util.Patterns.PHONE, R.string.validation_phone)

        formValidation.addValidation(activity, binding.aboutInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_web_url)
        formValidation.addValidation(activity, binding.aboutInput.id, "/^[a-z]{0,30}\$/", R.string.validation_max_char)

        formValidation.addValidation(activity, binding.websiteInput.id, android.util.Patterns.WEB_URL, R.string.validation_message)
        formValidation.addValidation(activity, binding.websiteInput.id, RegexTemplate.NOT_EMPTY, R.string.validation_web_url)


        formValidation.validate()
    }
}
