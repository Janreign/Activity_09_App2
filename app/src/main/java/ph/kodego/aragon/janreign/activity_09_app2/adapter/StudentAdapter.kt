package ph.kodego.aragon.janreign.activity_09_app2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.activity_09_app2.databinding.StudentItemBinding
import ph.kodego.aragon.janreign.activity_09_app2.model.Student

class StudentAdapter (var students: ArrayList<Student>)
    : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    fun addStudent (student: Student){
        students.add(0,student)
        notifyItemInserted(0)
    }

    fun removeStudent(position: Int){
        students.removeAt(position)
        notifyItemRemoved(position)
    }


    override fun getItemCount(): Int {
        return students.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewtype: Int
    ): StudentAdapter.StudentViewHolder {
        val itemBinding = StudentItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return StudentViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder,
                                  position: Int){
        holder.bindStudent(students[position])
    }

    inner class StudentViewHolder (private val itemBinding: StudentItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener{

        var student = Student()

        init {
            itemView.setOnClickListener(this)
        }
        fun bindStudent (student:Student){
            this.student = student

            itemBinding.studentName.text= "${student.lastname}, ${student.firstname}"
            itemBinding.btnDeleteRow.setOnClickListener{
                Snackbar.make(itemBinding.root,
                    "Delete by button",
                    Snackbar.LENGTH_SHORT
                )
            }
        }

        override fun onClick(p0: View?) {
            Snackbar.make(itemBinding.root,
                "${student.lastname}, ${student.firstname}",
                Snackbar.LENGTH_SHORT
            ).show()

            removeStudent(adapterPosition)
        }
    }
}