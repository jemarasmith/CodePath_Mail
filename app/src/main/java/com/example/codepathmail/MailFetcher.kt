package com.example.codepathmail

import android.widget.ImageView

class MailFetcher {
  companion object {
    val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
    val title = "Welcome to Kotlin!"
    val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."
//    var image = ""

    fun getEmails(): MutableList<Mail> {
      var emails : MutableList<Mail> = ArrayList()
      for (i in 0..9) {
        val email = Mail(senders[i], title, summary) //image)
        emails.add(email)

      }
      return emails
    }

    fun getNext5Emails(): MutableList<Mail> {
      var newEmails : MutableList<Mail> = ArrayList()
      for (i in 10..14) {
        val email = Mail(senders[i], title, summary)//image
        newEmails.add(email)
      }
      return newEmails
    }
  }
}
