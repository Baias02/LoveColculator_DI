package com.example.lovecolculator.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.lovecolculator.databinding.ItemOnboardBinding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf<OnBoard>(
        OnBoard(
            "Добро пожаловать",
            "Это приложение было создано для проверки",
            "https://pbs.twimg.com/media/ESwP_bQU4AAGsye.png:large"
        ),
        OnBoard(
            "Это проект студентов",
            "И прошу не критикуйте слишком строго",
            "https://checkroi.ru/wp-content/uploads/2022/07/kurs-prodzhekt-menedzher-ot-geekbrains.jpeg"
        ),
        OnBoard(
            "Этом все",
            "Если столкивались багами напишиоте тех поддержку",
            "https://cdn.dribbble.com/users/3859449/screenshots/9092146/artboard_2.jpg"
        ),
        OnBoard(
            "Этом все",
            "Если столкивались багами напишиоте тех поддержку",
            "https://cdn.dribbble.com/users/3859449/screenshots/9092146/artboard_2.jpg"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun onBind(onBoard: OnBoard) {
            with(binding) {

                text1Onboard.text = onBoard.title
                text2Onboard.text = onBoard.subTitle
                ivOnboard.load(onBoard.image)

                binding.btvOnboard.isVisible = adapterPosition == data.lastIndex
                binding.btvOnboard.setOnClickListener {
                    onClick()
                }
            }
        }

    }
}