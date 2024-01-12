import { useParams } from 'react-router-dom';

function Result() {
  const { id, type } = useParams();

  return (
    <div>
      <h1>Seu resultado está pronto!</h1>
      <p>
        Você tem chance de estar com a diabete{' '}
        {type == 'tipo 1' ? 'tipo 1' : 'tipo 2'}
      </p>
      <p>Procure um médico para agendar uma consulta oficial.</p>
    </div>
  );
}

export { Result };
