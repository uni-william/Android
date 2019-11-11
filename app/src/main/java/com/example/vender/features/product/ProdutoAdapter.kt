package com.example.vender.features.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vender.R
import com.example.vender.features.home.HomeFragmentDirections
import com.example.vender.models.Produto
import kotlinx.android.synthetic.main.produto_item.view.*

class ProdutoAdapter : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    private var produtos : MutableList<Produto> = mutableListOf()

    fun setData(produtos : MutableList<Produto>) {
        this.produtos = produtos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)

        val viewHolder = ProdutoViewHolder(view)

        view.setOnClickListener{
            it.findNavController().navigate(HomeFragmentDirections.navToDetailProduct(1))
        }

        return viewHolder
    }


    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        holder.bindData(produto)
    }


    class ProdutoViewHolder(private var  view : View) : RecyclerView.ViewHolder(view) {

        fun bindData(produto: Produto) {
            view.produto_id.text = produto.id.toString()
        }

    }
}