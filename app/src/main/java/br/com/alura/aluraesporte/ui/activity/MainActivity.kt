package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val controlador by lazy {
        findNavController(R.id.main_activity_nav_host)
    }

    private val viewModel: EstadoAppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        controlador.addOnDestinationChangedListener { controller,
                                                      destination,
                                                      arguments ->

            // Coloca o label do Fragment como título do Fragment na tela
            title = destination.label

            // Controla exibição da ActionBar conforme a tela
            when(destination.id) {
                R.id.listaProdutos -> supportActionBar?.show()
                R.id.login -> supportActionBar?.hide()
            }
        }
    }

}
