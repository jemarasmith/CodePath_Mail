package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.codepathmail.Mail
import com.example.codepathmail.R

class EmailAdapter(private val emails: List<Mail>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

      // Provide a direct reference to each of the views within a data item
      // Used to cache the views within the item layout for fast access

      // Your holder should contain a member variable for any view that will be set as you render
      // a row
      val senderTextView: TextView
      val titleTextView: TextView
      val summaryTextView: TextView
      var imageView: ImageView
        get() {
          TODO()
        }

      // We also create a constructor that accepts the entire item row
      // and does the view lookups to find each sub-view
      init {
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        senderTextView = itemView.findViewById(R.id.senderTV)
        titleTextView = itemView.findViewById(R.id.titleTV)
        summaryTextView = itemView.findViewById(R.id.summaryTV)
        imageView = itemView.findViewById(R.id.imageTV)

      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val context = parent.context
      val inflater = LayoutInflater.from(context)
      // Inflate the custom layout
      val contactView = inflater.inflate(R.layout.email_item, parent, false)
      // Return a new holder instance
      return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      // Get the data model based on position
      val email = emails.get(position)
      // Set item views based on views and data model
      holder.senderTextView.text = email.sender
      holder.titleTextView.text = email.title
      holder.summaryTextView.text = email.summary
      //holder.imageView.image
    }
    override fun getItemCount(): Int {
      return emails.size
    }
  }

