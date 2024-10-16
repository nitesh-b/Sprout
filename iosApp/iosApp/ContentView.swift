import UIKit
import SwiftUI
import ComposeApp
struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let vc = MainViewControllerKt.MainViewController()
        vc.view.backgroundColor = .red
        return vc
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ZStack {
                   Color.black
                       .ignoresSafeArea()
            ComposeView()
                .ignoresSafeArea(.all, edges: Edge.Set.top)
                    .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
           }
      
       
    }
}



