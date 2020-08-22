package art.maxandriani.droidquiz.workers;

import android.content.Context;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import art.maxandriani.droidquiz.domain.Question;
import art.maxandriani.droidquiz.domain.QuestionsDb;

public class SeedDatabaseWorker implements Runnable {

  private final Context context;
  private SeedDatabaseWorkerCallback success;
  private SeedDatabaseWorkerFail fail;

  private static final List<Question> questions = new ArrayList<Question>(
    Arrays.asList(
      new Question("A linguagem oficial para desenvolvimento Android Nativo pela Google é a Kotlin.", true),
      new Question("O processo de publicação do aplicativo na Google Play é gratuito.", false),
      new Question("O Brasil possui uma população de quase 210 milhões.", true),
      new Question("Flutter é uma dos frameworks de desenvolvimento mobile.", true),
      new Question("A linguagem de programação do Flutter é o Dart.", true),
      new Question("O Flutter possui interoperabilidade e pode ter projetos em Java e Dart", false),
      new Question("React-Native é uma plataforma para desenvolvimento de aplicativos móveis.", true),
      new Question("O Kotlin possui interoperabilidade oque possibilita implementar projetos em Java e Kotlin.", true)
    )
  );

  public SeedDatabaseWorker(Context context) {
    this.context = context;
  }

  public SeedDatabaseWorker(Context context, SeedDatabaseWorkerCallback success) {
    this(context);
    this.success = success;
  }

  public SeedDatabaseWorker(Context context, SeedDatabaseWorkerCallback success, SeedDatabaseWorkerFail fail) {
    this(context, success);
    this.fail = fail;
  }

  @Override
  public void run() {
    try {
      QuestionsDb db = QuestionsDb.getInstance(context);
      int count = db.questionDao().count();

      if (count != questions.size()) {
        db.questionDao().clear();

        for (Question question : questions) {
          db.questionDao().insert(question);
        }
      }
      if (success != null) {
        this.success.onSuccess();
      }
    } catch (Exception ex) {
      if (fail != null) {
        this.fail.onFail(ex);
      }
    }
  }
}
