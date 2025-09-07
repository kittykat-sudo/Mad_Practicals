class FileDownloader(private val fileName: String, private val downloadTime: Long) : Thread() {
    override fun run() {
        try {
            System.out.println("Starting download of $fileName...")
            
            // Simulate download time
            Thread.sleep(downloadTime)
            
            System.out.println("$fileName downloaded successfully!")
        } catch (e: InterruptedException) {
            System.out.println("Download of $fileName was interrupted!")
        }
    }
}

fun main() {
    System.out.println("Starting concurrent file downloads...")
    
    // Create two download threads
    val downloader1 = FileDownloader("file1.pdf", 2000) // 2 seconds
    val downloader2 = FileDownloader("file2.zip", 3000) // 3 seconds
    
    // Start downloads concurrently
    downloader1.start()
    downloader2.start()
    
    try {
        // Wait for both downloads to complete
        downloader1.join()
        downloader2.join()
        
        System.out.println("All downloads completed!")
    } catch (e: InterruptedException) {
        System.out.println("Main thread was interrupted!")
    }
}