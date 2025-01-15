package utils

import io.github.alexzhirkevich.compottie.assets.ImageRepresentable
import io.github.alexzhirkevich.compottie.assets.LottieAssetsManager
import io.github.alexzhirkevich.compottie.assets.LottieImageSpec


object CustomLottieAssetManager : LottieAssetsManager {
    override suspend fun image(image: LottieImageSpec): ImageRepresentable? {
        return null
    }

}
