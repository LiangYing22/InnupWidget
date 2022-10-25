package com.innup.widget.titlebar

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import com.innup.widget.R

class TitleBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        const val TAG = "TitleBarView"
        const val LEFT_IV_MIDDLE_TV = 0
        const val LEFT_TV = 1
        const val LEFT_TV_RIGHT_IV = 2
    }

    var type: Int = 0
    var leftImageResId : Int = -1
    var leftTextResId : Int = -1
    var middleTextResId : Int = -1
    var rightImageResId :Int = -1
    var rightTextResId :Int = -1

    lateinit var leftImageView: ImageView
    lateinit var leftTextView: TextView

    lateinit var middleTextView: TextView

    lateinit var rightImageView: ImageView
    lateinit var rightTextView: TextView


    init {
        init(context, attrs)
    }

    /**
     * 初始化View
     */
    private fun init(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.TitleBarView)
        type = a.getInt(R.styleable.TitleBarView_type, LEFT_IV_MIDDLE_TV)
        leftImageResId = a.getResourceId(R.styleable.TitleBarView_leftImage, -1)
        leftTextResId = a.getResourceId(R.styleable.TitleBarView_leftText, -1)
        rightImageResId = a.getResourceId(R.styleable.TitleBarView_rightImage, -1)
        rightTextResId = a.getResourceId(R.styleable.TitleBarView_rightText, -1)
        middleTextResId = a.getResourceId(R.styleable.TitleBarView_middleText, -1)
        Log.i(TAG, "type = $type")
        a.recycle()
        val view = LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this)
        leftImageView = view.findViewById(R.id.iv_title_bar_back_img)
        leftTextView = view.findViewById(R.id.tv_title_bar_left_text)
        middleTextView = view.findViewById(R.id.tv_title_bar_middle_text)
        rightImageView = view.findViewById(R.id.iv_title_bar_right_img)
        rightTextView = view.findViewById(R.id.tv_title_bar_right_text)
        setLeftIvSrc(leftImageResId)
        setLeftText(leftTextResId)
        setMiddleText(middleTextResId)
        setRightIvSrc(rightImageResId)
        setRightText(rightTextResId)
        if (type == LEFT_IV_MIDDLE_TV) {
            leftImageView.visibility = VISIBLE
            leftTextView.visibility = GONE
            middleTextView.visibility = VISIBLE
            rightImageView.visibility = GONE
            rightTextView.visibility = GONE
        }else if(type == LEFT_TV){
            leftImageView.visibility = GONE
            leftTextView.visibility = VISIBLE
            middleTextView.visibility = GONE
            rightImageView.visibility = GONE
            rightTextView.visibility = GONE
        }else if(type == LEFT_TV_RIGHT_IV){
            leftImageView.visibility = GONE
            leftTextView.visibility = VISIBLE
            middleTextView.visibility = GONE
            rightImageView.visibility = VISIBLE
            rightTextView.visibility = GONE
        }
    }

    fun setLeftIvSrc(resId : Int){
        if(resId == -1){
            return
        }
        leftImageResId = resId
        leftImageView.setImageResource(resId)
    }

    fun setLeftText(text : String){
        leftTextView.text = text
    }

    fun setLeftText(textId : Int){
        if(textId == -1){
            return
        }
        leftTextResId = textId
        leftTextView.setText(textId)
    }

    fun setMiddleText(text : String){
        middleTextView.text = text
    }

    fun setMiddleText(textId : Int){
        if(textId == -1){
            return
        }
        middleTextResId = textId
        middleTextView.setText(textId)
    }

    fun setRightIvSrc(resId : Int){
        if(resId == -1){
            return
        }
        rightImageResId = resId
        rightImageView.setImageResource(resId)
    }

    fun setRightText(text : String){
        rightTextView.text = text
    }

    fun setRightText(textId : Int){
        if(textId == -1){
            return
        }
        rightTextResId = textId
        rightTextView.setText(textId)
    }

    fun setLeftImgOnClickListener(l : ((View?) -> (Unit))?){
        leftImageView.setOnClickListener(l)
    }

    fun setLeftTextOnClickListener(l : ((View?) -> (Unit))?){
        leftTextView.setOnClickListener(l)
    }

    fun setRightImgOnClickListener(l : ((View?) -> (Unit))?){
        rightImageView.setOnClickListener(l)
    }

    fun setRightTextOnClickListener(l : ((View?) -> (Unit))?){
        rightTextView.setOnClickListener(l)
    }

}