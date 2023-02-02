package com.example.codepathmail


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.EmailAdapter

class MainActivity : AppCompatActivity() {

  lateinit var emails: List<Mail>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Lookup the RecyclerView in activity layout
    val mail = findViewById<RecyclerView>(R.id.mail)
    // Fetch the list of emails
    emails = MailFetcher.getEmails()
    // Create adapter passing in the list of emails
    val adapter = EmailAdapter(emails)
    // Attach the adapter to the RecyclerView to populate items
    mail.adapter = adapter
    // Set layout manager to position the items
    mail.layoutManager = LinearLayoutManager(this)

    findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
      // Fetch next 5 emails and display in RecyclerView
      val newEmails = MailFetcher.getNext5Emails()
      // Add new emails to existing list of emails
      (emails as MutableList<Mail>).addAll(newEmails)
      // Notify the adapter there's new emails so the RecyclerView layout is updated
      adapter.notifyDataSetChanged()
    }
  }
}
