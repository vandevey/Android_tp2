package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.databinding.ActivityMainBinding
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(), NavigationListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //toolbar = binding.toolbar
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        showFragment(ListNeighborsFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun updateTitle(title: Int) {
        binding.toolbar.setTitle(title)
    }
}