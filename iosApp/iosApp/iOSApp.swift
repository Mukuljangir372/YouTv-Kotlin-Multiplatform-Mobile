import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
       let graph = BaseGraph()
        graph.doInitKoin(driverFactory: DatabaseDriverFactory())
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
