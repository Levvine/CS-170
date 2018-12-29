// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;

import acm.graphics.GImage;

import acm.breadboards.BreadboardComboBoxModel;
import acm.breadboards.ComboBoxWithButtonsBreadboard;


public class PhotoProcessor extends ComboBoxWithButtonsBreadboard {
	
	public final int NO_FILTER = 0;
	public final int GRAYSCALE = 1;
	public final int NEGATIVE = 2;
	public final int BLURRED = 3;
	
	GImage originalImage_;
	GImage currentImage_;

	public void run() {
		
		//set up the breadboard with instructions, labels, etc...
		this.getLabel().setText("Filters:");
		
		this.getTextArea().setText("This program will apply one of four filters to an image. " +
		                           "Click 'Load' and select an image file with which to work. " +
				                   "Then select an appropriate filter, and click 'Apply' to see the result.");
		
		String[] options = {"No Filter", "Grayscale", "Negative", "Blurred"};
		BreadboardComboBoxModel model = new BreadboardComboBoxModel(options);
		this.getComboBox().setModel(model);
		
		this.getButton2().setText("Load...");
		
		this.getButton1().setText("Apply Filter");
	}
	
	public void onButton1Click() { //Apply Filter button was clicked...
		
		//remove the old image
		this.remove(currentImage_);
		
		//add the newly filtered image
		switch (this.getComboBox().getSelectedIndex()) {
		case NO_FILTER: this.add(originalImage_);
						currentImage_ = originalImage_;
						break;
		case GRAYSCALE: currentImage_ = makeGrayscale(currentImage_);
						this.add(currentImage_);
						break;
		case NEGATIVE:  currentImage_ = makeNegative(currentImage_);
						this.add(currentImage_);
						break;
		case BLURRED: 	currentImage_ = makeBlurred(currentImage_);
						this.add(currentImage_);
						break;
		}
		
	}
	
	public void onButton2Click() { //Load button was clicked
		
		//get the name of an image file the user has selected
		final JFileChooser fileChooser = new JFileChooser();
		int fileChooserAction = fileChooser.showOpenDialog(this);
		
		if (fileChooserAction == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String fileName = file.getPath();
			
			//construct GImages for the original picture, and the grayscale, negative, and blurred versions
			originalImage_ = new GImage(fileName);
			currentImage_ = originalImage_;
			this.add(originalImage_);
			
			//adjust the window size so that the central canvas area fits the picture
			int northHeight = this.getRegionPanel(NORTH).getHeight();
			int southHeight = this.getRegionPanel(SOUTH).getHeight();
			this.setSize((int) originalImage_.getWidth(), (int) originalImage_.getHeight() + northHeight + southHeight);
		}
	}
	
	public GImage makeGrayscale(GImage image) {
        
	    int[][] pixelArray = image.getPixelArray();
	    
	    for (int i = 0; i < pixelArray.length; i++) {
	        for(int j = 0; j < pixelArray[i].length; j++) {
	            int red = GImage.getRed(pixelArray[i][j]);
	            int green = GImage.getGreen(pixelArray[i][j]);
	            int blue = GImage.getBlue(pixelArray[i][j]);
	            int average = (red + green + blue) / 3;
	            pixelArray[i][j] = GImage.createRGBPixel(average, average, average);
	        }
	    } 
	    
	    image = new GImage(pixelArray);
	    return image;
	    
	}
	
	public GImage makeNegative(GImage image) {
        
	    int[][] pixelArray = image.getPixelArray();
	    for (int i = 0; i < pixelArray.length; i++) {
	        for(int j = 0; j < pixelArray[i].length; j++) {
	            int red = 255 - GImage.getRed(pixelArray[i][j]);
	            int green = 255 - GImage.getGreen(pixelArray[i][j]);
	            int blue = 255 - GImage.getBlue(pixelArray[i][j]);
	            pixelArray[i][j] = GImage.createRGBPixel(red, green, blue);
	        }	            
	    }
	    image = new GImage(pixelArray);
	    return image;
	    
	}
	
	public GImage makeBlurred(GImage image) {
	    
	    int[][] pixelArray = image.getPixelArray();
	    int[][] newPixelArray = image.getPixelArray();
	    for (int i = 0; i < pixelArray.length; i++) {
	        for (int j = 0; j < pixelArray[i].length; j++) {
	            int red = 0;
                int green = 0;
                int blue = 0;
                int radius = 3;
                int count = 0;
	            for (int y = i - radius; y <= i + radius; y++) {
	                for (int x = j - radius; x <= j + radius; x++) {
	                    if ((y > 0) && (y < pixelArray.length) &&
	                       (x > 0) && (x < pixelArray[i].length) &&
	                       ((Math.abs(i - y) + Math.abs(j - x)) <= radius)) {
	                        red += GImage.getRed(pixelArray[y][x]);
	                        green += GImage.getGreen(pixelArray[y][x]);
	                        blue += GImage.getBlue(pixelArray[y][x]);
	                        count++;
	                    }
	                }
	            } 
	            red /= count;
                green /= count;
                blue /= count;
                newPixelArray[i][j] = GImage.createRGBPixel(red, green, blue);
	        }
	    }
	    image = new GImage(newPixelArray);
	    return image;
	    
	}
}

