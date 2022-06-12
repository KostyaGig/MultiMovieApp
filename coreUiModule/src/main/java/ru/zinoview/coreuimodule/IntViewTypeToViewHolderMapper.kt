package ru.zinoview.coreuimodule

import android.view.ViewGroup
import ru.zinoview.core.Mapper

interface IntViewTypeToViewHolderMapper<T : UiModel> : Mapper<Pair<ViewGroup,Int>,BaseViewHolder<T>>
