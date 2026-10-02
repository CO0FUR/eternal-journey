package eternaljourney;

import arc.Core;
import arc.graphics.Color;
import arc.scene.ui.Dialog;
import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;
import arc.util.Timer;

public class START {

    public static void showIntro() {
        Core.app.post(() -> {
            Dialog dialog = new Dialog("永恒的旅途");
            dialog.setFillParent(true);

            // 🎯 去掉背景
            dialog.setBackground(null);
            dialog.cont.background(null);

            Table content = new Table();

            // 标题
            content.add("永恒的旅途").fontScale(3f).color(Color.yellow).padTop(60f).row();
            content.add("Eternal Journey").fontScale(1.2f).color(Color.gray).padTop(10f).padBottom(40f).row();

            // 🎯 打字机文字
            Label introLabel = new Label("");
            introLabel.setColor(Color.white);
            introLabel.setFontScale(1.3f);
            content.add(introLabel).padTop(20f).padBottom(30f).row();

            // 🎯 打字机文字内容
            String fullText = "“旅途没有终点，只有一段又一段的开始。”\n\n" +
                    "你从沉睡中醒来，\n" +
                    "发现自己站在一片陌生的荒野上。\n" +
                    "远方的天际线，\n" +
                    "似乎有什么在呼唤着你。\n\n" +
                    "—— 你的旅途，从现在开始。";

            // 🎯 逐字显示
            Timer.schedule(new Timer.Task() {
                int index = 0;
                @Override
                public void run() {
                    if (index < fullText.length()) {
                        int i = index;
                        Core.app.post(() -> introLabel.setText(fullText.substring(0, i + 1)));
                        index++;
                    } else {
                        this.cancel();
                    }
                }
            }, 0f, 0.1f);

            content.button("开始旅途", dialog::hide).size(200f, 50f).padTop(20f);

            dialog.cont.add(content);
            dialog.show();
        });
    }
}