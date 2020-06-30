package bjamee;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	private static ImageLoader imageLoader = new ImageLoader();
	
	private ImageLoader() {
		
	}
	
	public BufferedImage load(String path) {
		BufferedImage image = null;
		try {
		    image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return image;
	}
	
	public static ImageLoader getImageLoader() {
		return imageLoader;	
	}

}
