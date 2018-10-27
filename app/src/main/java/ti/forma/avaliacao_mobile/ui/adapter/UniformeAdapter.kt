package ti.forma.avaliacao_mobile.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.uniforme_list_item.view.*
import ti.forma.avaliacao_mobile.R
import ti.forma.avaliacao_mobile.model.Uniforme

class UniformeAdapter (private val uniformeItemList : List<Uniforme>,
                       private val context: Context
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as UniformeViewHolder).bind(uniformeItemList[position])
    }

    override fun getItemCount() = uniformeItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.uniforme_list_item, parent, false)
        return UniformeViewHolder(view)
    }

    class UniformeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(uniformes: Uniforme){
            itemView.rv_uniforme_name.text = uniformes.uniforme
            itemView.rv_uniforme_tamanho.text = uniformes.tamanho
            itemView.rv_uniforme_categoriaId.text = uniformes.categoriaId.toString()
            itemView.rv_uniforme_disponibilidade.text = uniformes.disponibilidade.toString()
            itemView.rv_uniforme_id.text = uniformes.id.toString()
            itemView.rv_uniforme_dataCadastro.text = uniformes.dataCadastro
            itemView.rv_uniforme_monitor.text = uniformes.monitor.toString()
            itemView.rv_uniforme_movimentacoes.text = uniformes.movimentacoes.toString()
            itemView.rv_uniforme_sexo.text = uniformes.sexo
            itemView.rv_uniforme_tamanhoId.text = uniformes.tamanhoId
        }
    }
}