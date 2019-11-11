package com.example.vender.features.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.vender.R
import com.example.vender.features.product.ProdutoAdapter
import com.example.vender.models.Produto
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private var produtoAdapter = ProdutoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val produtos = mutableListOf(Produto(1), Produto(2), Produto(3))
        lista_produtos.layoutManager = LinearLayoutManager(activity)
        produtoAdapter.setData(produtos)
        lista_produtos.adapter = produtoAdapter
    }


}
