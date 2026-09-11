package test;

/**
 * listeners and callbacks are a fundamental implementation of the 
 * Observer Design Pattern in Java
 */

class FileDownloader {
	
	// 1. Define the nested interface scoped to this class
	public interface DownloadCallback {
		void onStart();
		void onProgress(int percentage);
		void onError(String errorMessage);
	}
	
	private DownloadCallback callback;
	
	// 2. Allow a listener to register themselves
	public void setDownloadCallback(DownloadCallback callback) {
		this.callback = callback;
	}
	
	// 3. Trigger the callback methods at specific lifecycles
	public void startDownload(String fileUrl) {
		if (callback != null) {
			callback.onStart();
		}
		
		try {
			// Simulating a download progress loop
			for (int i = 25; i <= 100; i += 25) {
				Thread.sleep(200); // Simulating network lag
				if (callback != null) {
					callback.onProgress(i);
				}
			}
		} catch (Exception e) {
			if (callback != null) {
				callback.onError(e.getMessage());
			}
		}
	}
}

/**
 * Option A: Implementing via a Concrete Class
 */
class DownloadManager implements FileDownloader.DownloadCallback {
	
	public void initializeTask() {
		FileDownloader downloader = new FileDownloader();
		
		// Pass 'this' because DownloadManager implements the nested interface
		downloader.setDownloadCallback(this);
		downloader.startDownload("https://example.com");
    }
	
	@Override
	public void onStart() {
		System.out.println("Manager: Download has initiated.");
	}
	
	@Override
	public void onProgress(int percentage) {
		System.out.println("Manager: Progress is at " + percentage + "%");
	}
	
	@Override
	public void onError(String errorMessage) {
		System.err.println("Manager: Download failed due to: " + errorMessage);	
	}
}

public class Design_Pattern_Listeners_and_Callbacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DownloadManager downloadManger = new DownloadManager();
		downloadManger.initializeTask();

		
		
		/**
		 * Option B: Implementing via an Anonymous Inner Class
		 */
		
		FileDownloader downloader = new FileDownloader();
		
		// Instantiate the nested interface inline
        downloader.setDownloadCallback(new FileDownloader.DownloadCallback() {
        	@Override
        	public void onStart() {
        		System.out.println("UI: Showing progress bar...");
        	}
        	
        	@Override
        	public void onProgress(int percentage) {
        		System.out.println("UI: Updating progress bar to " + percentage + "%");
        	}
        	
        	@Override
        	public void onError(String errorMessage) {
        		System.out.println("UI: Displaying error dialog: " + errorMessage);
        	}
        });
        
        downloader.startDownload("https://example.com");
	}
}
