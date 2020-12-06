import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenotes.Note
import com.example.simplenotes.R

class MainAdapter(var items: List<Note>, val callback: Callback) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        private val firstName = itemView.findViewById<TextView>(R.id.firstName)
//        private val lastName = itemView.findViewById<TextView>(R.id.lastName)

        fun bind(item: Note) {
//            firstName.text = item.firstName
//            lastName.text = item.lastName
//            itemView.setOnClickListener {
//                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
//            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Note)
    }

}