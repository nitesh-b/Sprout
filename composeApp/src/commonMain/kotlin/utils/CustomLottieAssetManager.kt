package utils

import io.github.alexzhirkevich.compottie.assets.ImageRepresentable
import io.github.alexzhirkevich.compottie.assets.LottieAssetsManager
import io.github.alexzhirkevich.compottie.assets.LottieImage

object CustomLottieAssetManager : LottieAssetsManager {
    override suspend fun image(image: LottieImage): ImageRepresentable? {
        return null
    }
}
