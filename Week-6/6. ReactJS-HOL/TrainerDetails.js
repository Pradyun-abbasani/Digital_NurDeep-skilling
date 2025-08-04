import { useParams } from "react-router-dom";

function TrainerDetails({ trainers }) {
  const { id } = useParams();
  const trainer = trainers.find(t => t.trainerId === id);

  return (
    <div>
      <h2>Trainers Details</h2>
      <p><strong>{trainer.name} ({trainer.technology})</strong></p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetails;
