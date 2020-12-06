import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenotes.Note
import com.example.simplenotes.R

class MainAdapter(var items: List<Note>, val callback: Callback) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_note, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtName = itemView.findViewById<TextView>(R.id.txtName)
        private val txtDescription = itemView.findViewById<TextView>(R.id.txtDescription)
        private val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)

        fun bind(item: Note) {
            txtName.text = item.text
            txtDescription.text = item.name
            checkBox.isChecked = item.status
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Note)
    }

}