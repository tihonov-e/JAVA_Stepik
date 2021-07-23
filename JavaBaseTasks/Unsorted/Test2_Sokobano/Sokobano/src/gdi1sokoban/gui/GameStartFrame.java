package gdi1sokoban.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import gdi1sokoban.SoundMaster;
import gdi1sokoban.control.Game;
import gdi1sokoban.graphic.base.TextureDescriptor;
import gdi1sokoban.graphic.base.TextureManager;
import gdi1sokoban.gui.event.ActionEvent;
import gdi1sokoban.gui.event.ActionListener;
import gdi1sokoban.gui.event.FrameEvent;
import gdi1sokoban.gui.event.KeyboardEvent;
import gdi1sokoban.gui.event.KeyboardListener;
import gdi1sokoban.gui.event.MouseEvent;
import gdi1sokoban.gui.event.MouseListener;
import gdi1sokoban.logic.Board;
import gdi1sokoban.logic.ConfigManager;
import gdi1sokoban.logic.GlobalConfig;
import gdi1sokoban.logic.Level;
import gdi1sokoban.logic.LevelSetIdentifier;
import gdi1sokoban.logic.LevelStatistic;
import gdi1sokoban.logic.Player;
import gdi1sokoban.logic.Position;
import gdi1sokoban.logic.Savegame;

//vor dem Start: -> game mit 
//     Rotation rendern, keine Eingaben zulassen.
//     Wenn schon Moves verfügbar, mit doppelter Geschwindigkeit rendern
//     Wenn keine Replay:
//       Nach max. 3 Sek. automatisch zum Game(Play)Frame
//       Mit Klick zum Game(Play)Frame oder zurück.
// = GameStartFrame
public class GameStartFrame extends Frame {

	private Button _buttonBack;
	private Button _buttonStart;
	private Button _buttonRestart;
	private Label _labelPoints;
	private Label _labelTime;
	private Label _labelPlayer;
	
	private LevelStatistic _levelStatistic;
	private Level _level;
	private LevelSetIdentifier _levelSetIdentifier;
	private Player _player;
	private Game _game;
	private long _time;
	
	private long _timebase = System.currentTimeMillis();
	private static float _angleX, _angleY = 70, _zoom = 30, _mouseX,_mouseY;
	private boolean _rotate;
	private boolean _autorotate = true;
	private static boolean _freeCam = false;
	
	public GameStartFrame(Frame frame, LevelSetIdentifier levelSetIdentifier, Level level, Player player, LevelStatistic levelStatistic) throws Exception {
		super(frame);
		initialize(frame, levelSetIdentifier, level, player, levelStatistic, null);
	}
		
	public GameStartFrame(Frame frame, LevelSetIdentifier levelSetIdentifier, Level level, Player player, LevelStatistic levelStatistic, Savegame savegame) throws Exception {
		super(frame);
		initialize(frame, levelSetIdentifier, level, player, levelStatistic, savegame);
	}
	
	public void initialize(Frame frame, LevelSetIdentifier levelSetIdentifier, Level level, Player player, LevelStatistic levelStatistic, Savegame savegame) throws Exception {
		
		_level = level;
		_levelSetIdentifier = levelSetIdentifier;
		_player = player;
		_levelStatistic = levelStatistic;
		
		GlobalConfig globalConfig = ConfigManager.getInstance().getGlobalConfig();
		
		_buttonBack = new Button(-0.5f, -0.49f, 0.11f, 0.08f, "", Button.CAP_LEFT);
		_buttonBack.addActionListener(new ButtonBackActionListener());
		_buttonBack.setIconTexture(TextureManager.getInstance().getInstance(new TextureDescriptor("res/textures/gui/back_icon.png", GL11.GL_LINEAR, GL11.GL_LINEAR)));
		add(_buttonBack);
		
		_labelPlayer = new Label(-0.38f, -0.49f, 0.45f, 0.08f, _level.getName());
		add(_labelPlayer);
		
		_labelPoints = new Label(0.08f, -0.49f, 0.2f, 0.08f, String.valueOf(_levelStatistic.getMoves()));
		_labelPoints.setIconTexture(TextureManager.getInstance().getInstance(new TextureDescriptor("res/textures/gui/step_icon.png", GL11.GL_LINEAR, GL11.GL_LINEAR)));
		add(_labelPoints);
		
		_labelTime = new Label(0.29f, -0.49f, 0.21f, 0.08f, String.valueOf(_levelStatistic.getTime()/1000), Label.CAP_RIGHT);
		_labelTime.setIconTexture(TextureManager.getInstance().getInstance(new TextureDescriptor("res/textures/gui/clock_icon.png", GL11.GL_LINEAR, GL11.GL_LINEAR)));
		add(_labelTime);
		
		// Resume or replay:
		if (savegame != null) {
			_level.setMoves(savegame.getMoves());
			_time = savegame.getTime();
			_labelPoints.setText(String.valueOf(_level.getTotalStepCount()));
			_labelTime.setText(String.valueOf(_time/1000));
			
			// Replay:
			if (savegame.isWon()) {
				_buttonRestart = new Button(-0.2f, 0.41f, 0.4f, 0.08f, "Again", Label.CAP_BOTH);
				_buttonRestart.addActionListener(new ButtonRestartActionListener());
				_buttonRestart.setIconTexture(TextureManager.getInstance().getInstance(new TextureDescriptor("res/textures/gui/restart_icon.png", GL11.GL_LINEAR, GL11.GL_LINEAR)));
				add(_buttonRestart);
			}
		}
		else {
			_time = 0;
		}
		
		// No replay:
		if (!(savegame != null && savegame.isWon())) {
			_buttonStart = new Button(-0.2f, 0.35f, 0.4f, 0.08f, "Start", Button.CAP_BOTH);
			_buttonStart.setIconTexture(TextureManager.getInstance().getInstance(new TextureDescriptor("res/textures/gui/start_icon.png", GL11.GL_LINEAR, GL11.GL_LINEAR)));
			_buttonStart.addActionListener(new ButtonStartActionListener());
			add(_buttonStart);
			setFocus(_buttonStart, true);
		}

		addKeyboardListener(new FrameKeyboardListener());
		addMouseListener(new FrameMouseMoveListener());

		_game = new Game(level, player, globalConfig.isReflections());
	}
	
	private class ButtonStartActionListener implements ActionListener {
		public void actionEvent(ActionEvent event) {
			if (event.getCommand() == Button.ACTION_PRESSED) {
				try {
					// Resume level:
					_level.forward();
					_game.forward();
					
					Frame nextFrame = new GameFrame(GameStartFrame.this, _game, _levelSetIdentifier, _level, _player, _levelStatistic, _time);
					processFrameEvent(new FrameEvent(FrameEvent.FRAME_EXIT, nextFrame));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class ButtonRestartActionListener implements ActionListener {
		public void actionEvent(ActionEvent event) {
			if (event.getCommand() == Button.ACTION_PRESSED) {
				_game.restart();
				_game.forward();
			}
		}
	}
	
	private class ButtonBackActionListener implements ActionListener {
		public void actionEvent(ActionEvent event) {
			if (event.getCommand() == Button.ACTION_PRESSED) {
				SoundMaster.playMainMenu();
				try {
					Frame nextFrame = new PlayerFrame(GameStartFrame.this, _player);
					processFrameEvent(new FrameEvent(FrameEvent.FRAME_EXIT, nextFrame));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private class FrameMouseMoveListener implements MouseListener {
		public boolean mouseEvent(MouseEvent event) {
			_showCursor = true;
			
			// Calculate Camera position:
			if (event.getButton() == 1) {
				_rotate = Mouse.getEventButtonState();
				if (_rotate) _autorotate = false;
			}

			if (event.getType() == MouseEvent.MOUSE_MOVED) {			
				if (Mouse.isButtonDown(1)) {
					_angleX += (event.getX()-_mouseX)*200;
					if (_angleX < 0) _angleX+=360;
					_angleY += (event.getY()-_mouseY)*200;
					if (_angleY < 3) _angleY = 3;
					if (_angleY >= 89.999f) _angleY = 89.999f;  // Mac OS X compatibility
					
				}
				_mouseX = event.getX();
				_mouseY = event.getY();
				_game.buildCamera(_angleY, _angleX, _zoom);
			}
			
			return false;
		}
	}
	
	private class FrameKeyboardListener implements KeyboardListener {
		public boolean keyboardEvent(KeyboardEvent event) {
			if (event.getState()) {
				switch (event.getCode()) {
				case Keyboard.KEY_ESCAPE :
					if (event.getState()) {
						
						try {
							Frame nextFrame = new PlayerFrame(GameStartFrame.this, _player);
							processFrameEvent(new FrameEvent(FrameEvent.FRAME_EXIT, nextFrame));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
					
				case Keyboard.KEY_W : 
				case Keyboard.KEY_ADD : 
				case Keyboard.KEY_EQUALS :
					if (!_rotate && (_zoom > 1)) _zoom /= 1.08f;
					break;
					
				case Keyboard.KEY_S : 
				case Keyboard.KEY_MINUS : 
				case Keyboard.KEY_SUBTRACT : 
					if (!_rotate && (_zoom < 100)) _zoom *= 1.08f;
					break;
					
				case Keyboard.KEY_C :
					_freeCam = !_freeCam;
					break;
					
				case Keyboard.KEY_Q : 
					_angleX-=90;
					if (_angleX < 0) _angleX+=360;
					break;
					
				case Keyboard.KEY_E : 
					_angleX+=90;
					break;
				}
			}
			return false;
		}
	}
	
	public void render() {
		if (_level.canRedo() && !_game.isMoving())
			_level.redo();
		
		if (_autorotate) {
			_angleX = (System.currentTimeMillis() - _timebase)/100.0f;
		} else {
			if (!_rotate && !_freeCam) {
				int min = (int)(_angleX / 90) * 90;
				int max = min + 90;
				float add = (_angleX - min - 45) / 100.0f;
			
				if (add < 0)
					if ((_angleX-=2) > min) _angleX-=2;
					else _angleX = min;
				else 
					if ((_angleX+=2) < max) _angleX+=2;
					else _angleX = max;
			}
			
		}
		
		_game.buildCamera(_angleY, _angleX, _zoom);
		_game.render(System.currentTimeMillis());
		super.render();
	}
}
